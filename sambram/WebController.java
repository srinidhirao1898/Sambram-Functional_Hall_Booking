package com.webapp.sambram;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.webapp.sambram.Dto.LoginDto;
import com.webapp.sambram.Dto.SignUpDto;
import com.webapp.sambram.Entities.Bookings;
import com.webapp.sambram.Entities.BookingsId;
import com.webapp.sambram.Entities.FunctionHall;
import com.webapp.sambram.Entities.HallPrice;
import com.webapp.sambram.Entities.Role;
import com.webapp.sambram.Entities.Usr01;
import com.webapp.sambram.Entities.Usrpass;
import com.webapp.sambram.repositories.BookingsRepository;
import com.webapp.sambram.repositories.FunctionHallRepository;
import com.webapp.sambram.repositories.HallPriceRepository;
import com.webapp.sambram.repositories.RoleRepository;
import com.webapp.sambram.repositories.Usr01Repository;
import com.webapp.sambram.repositories.UsrpassRepository;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class WebController {
	@Autowired
	private Usr01Repository usr01Repository;
	@Autowired
	private FunctionHallRepository functionHallRepository;
	@Autowired
	private HallPriceRepository hallPriceRepository;
	@Autowired
	private UsrpassRepository usrPassRepository;
	@Autowired
	private BookingsRepository bookingsRepository;
//	@Autowired
	//private FumctionalHallRepoGet functionHallRepoGet = new FumctionalHallRepoGet();
	private int functionHallId;
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private Usr01Repository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private String email;
	
	
	@GetMapping(value = "/Home") 																//Home Page
	public String homePage()
	{
		return "Home_Page";
	}

	
	@GetMapping(value = "/Register/FuncHall")													//Hall Register Get
	public String functionHallGet()
	{
		return "Func_Register";
	}
	
	@PostMapping(value = "/Register/FuncHall")													//Hall Register Post
	public String functionHallRegister(@RequestParam String HallName,  
			@RequestParam String Address1, @RequestParam String Address2, 
			@RequestParam String Area1, @RequestParam String City,
			@RequestParam String Pincode, @RequestParam String Phone1, @RequestParam String Phone2)
	{
		FunctionHall hallNew = new FunctionHall();
		functionHallId = functionHallRepository.findMaxId();
		hallNew.setHallid(functionHallId + 1);
		hallNew.setHallName(HallName);
		hallNew.setAddress1(Address1);
		hallNew.setAddress2(Address2);
		hallNew.setArea1(Area1);
		hallNew.setCity(City);
		hallNew.setPincode(Pincode);
		hallNew.setPhone1(Phone1);
		hallNew.setPhone2(Phone2);
		functionHallRepository.save(hallNew);
		return "Set_HallPrice";
	}
	
	@GetMapping(value = "/Register/HallPrice") 													//Hall Price Register Get
	public String hallPriceSetGet()
	{
		return "Set_HallPrice";
	}
	
	@PostMapping(value = "/Register/HallPrice")														 //Hall Price Register Post
	public String hallPriceSet(@RequestParam String AcNonac1, @RequestParam float PricePerDay1,
			@RequestParam String AcNonac2, @RequestParam float PricePerDay2)
	{
		HallPrice newHallPrice = new HallPrice();
		HallPrice newHallPriceNonAc = new HallPrice();
		//functionHallId = functionHallRepository.findMaxId();
		newHallPrice.setHallid(functionHallId + 1);
		newHallPrice.setAcNonac(AcNonac1);
		newHallPrice.setPricePerDay(PricePerDay1);
		
		newHallPriceNonAc.setHallid(functionHallId + 1);
		newHallPriceNonAc.setAcNonac(AcNonac2);
		newHallPriceNonAc.setPricePerDay(PricePerDay2);
		hallPriceRepository.save(newHallPrice);
		hallPriceRepository.save(newHallPriceNonAc);
		return "Set_HallPrice";
	}
	
	
	@GetMapping(value = "/Gethall")
	public String getDateInput()
	{
		return "Date_Get";
	}
	
	@PostMapping(value = "/Gethall")
	//@ResponseBody
	public String postDateInput(@RequestParam Date fromDate, @RequestParam Date toDate, Model model,
			HttpServletRequest request,RedirectAttributes redirAttrs)             						//Get Hall
	{
		java.sql.Date today=new java.sql.Date(System.currentTimeMillis());
		if(today.after(fromDate)) {
			redirAttrs.addFlashAttribute("error", "Enter Date Greater than Today");
			return "redirect:/Gethall";
		}
			
		List<Object[]> sqlList = functionHallRepository.findHallId(fromDate, toDate);
		List<HallAvailable> hallList = new ArrayList<>();
		
		for(Object[] ol: sqlList)
		{
			HallAvailable n = new HallAvailable((int)ol[0],(String)ol[1],(String)ol[2],(String)ol[3],(String)ol[4],
					(String)ol[5],(String)ol[6],(float)ol[7],fromDate,toDate);
			hallList.add(n);
		}
		model.addAttribute("hallList", hallList);
		return "Halls_List";
	}
	
	@GetMapping(value = "/book/{hall_id}/{hall_name}/{AcNonac}/{fromDate}/{toDate}")														//Book Hall level 2
	public String bookHallGet(@PathVariable("hall_id") int hall_id, @PathVariable("hall_name") String hall_name,@PathVariable("AcNonac") String AcNonac,
			@PathVariable("fromDate") Date fromDate,@PathVariable("toDate") Date toDate, Model model,RedirectAttributes redirAttrs)
	{
		if(email == null)
		{
			redirAttrs.addFlashAttribute("pleaseLog", "Please log-in to book");
			return "redirect:/login";
		}
		model.addAttribute("hallId",new HallIds(hall_id, hall_name, AcNonac, fromDate, toDate));
		return "book_hall_l2";
	}
	
	@PostMapping(value = "/book/{hall_id}/{hall_name}/{AcNonac}/{fromDate}/{toDate}")
	public String bookHallPost(@PathVariable("hall_id") int hall_id,@PathVariable("hall_name") String hall_name,
			@PathVariable("AcNonac") String AcNonac,
			@PathVariable("fromDate") Date fromDate,@PathVariable("toDate") Date toDate,@RequestParam float AdvancePaid, Model model,
			RedirectAttributes redirAttrs)
	{
		Bookings nb = new Bookings();
		BookingsId nids = new BookingsId();
		long days_booked = toDate.getTime() - fromDate.getTime();
		float days_bkd = TimeUnit.DAYS.convert(days_booked, TimeUnit.MILLISECONDS);
		int price_per_day = hallPriceRepository.getAmount(hall_id, AcNonac);
		nids.setHallId(hall_id);
		nids.setUserMail(email);
		nb.setBookingsId(nids);
		nb.setAcNonac(AcNonac);
		nb.setFromDate(fromDate);
		nb.setToDate(toDate);
		nb.setAdvancePaid(AdvancePaid);
		nb.setAmountToBePaid(days_bkd*price_per_day - AdvancePaid);
		bookingsRepository.save(nb);
		List<Object[]> userBookings = bookingsRepository.getBookinsUser(email);
		model.addAttribute("userBookings",userBookings);
		return "user_bookings";
	}
	
	@GetMapping(value = "/{userMail}")
	public String getBookings(@PathVariable("userMail") String userMail,Model model)
	{
		List<Object[]> userBookings = bookingsRepository.getBookinsUser(userMail);
		model.addAttribute("userBookings",userBookings);
		return "user_bookings";
	}
	
	//Authorizations...............................
	
	@PostMapping("/login")
    public RedirectView authenticateUser(Model model,@ModelAttribute("loginDto") LoginDto loginDto,RedirectAttributes redirAttrs){
        try 
        	{
        		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUserMail(), loginDto.getPassword()));

		        SecurityContextHolder.getContext().setAuthentication(authentication);
		        email = loginDto.getUserMail();
		        model.addAttribute("loginDto", loginDto);
        
        	}
        catch (BadCredentialsException ex)
        {
        	redirAttrs.addFlashAttribute("error", "Invalid credentials");
        	return new RedirectView("/login");
        }
        return new RedirectView("/Home");
    }
	
	@GetMapping("/login")
    public String passUserGet(Model model,RedirectAttributes redirAttrs)
    {
		if(email != null)
		{
			redirAttrs.addFlashAttribute("alreadylogin", "You have already loged in");
			return "redirect:/Home";
		}
		LoginDto loginDto = new LoginDto();
		model.addAttribute("loginDto", loginDto);
    	return "Set_Password";	    }
    
    @GetMapping("/signup")
    public String registerUserGet(Model model)
    {
    	SignUpDto signUpDto = new SignUpDto();
    	model.addAttribute("signUpDto", signUpDto);
    	return "User_Registration";	    }

    @PostMapping("/signup")
    //@ResponseBody
    public RedirectView registerUser(Model model,@ModelAttribute("signUpDto") SignUpDto signUpDto, RedirectAttributes redirAttrs){

        // add check for email exists in DB
        if(userRepository.existsByEmail(signUpDto.getUserMail())){
        	//return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        	redirAttrs.addFlashAttribute("error", "User with this email already exists");
        	return new RedirectView("/signup");
        }

        // create user object
        Usr01 user = new Usr01();
        user.setFirstName(signUpDto.getFirstName());
        user.setLastName(signUpDto.getLastName());
        user.setMiddleName(signUpDto.getMiddleName());
        user.setEmail(signUpDto.getUserMail());
        user.setPhone1(signUpDto.getPhone1());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));
        
        userRepository.save(user);
        model.addAttribute("signUpDto", signUpDto);
        

        //return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
        return new RedirectView("/login");

    }
}
