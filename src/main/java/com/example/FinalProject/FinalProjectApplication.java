package com.example.FinalProject;



import com.example.FinalProject.service.StockApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;




@SpringBootApplication
public class FinalProjectApplication implements CommandLineRunner {


//    @Autowired
//    private MyUserRepository repository;
//
//    @PostConstruct
//    public void initUsers() {
//        List<MyUser> users = Stream.of(
//                new MyUser(101L, "javatechie", "password"),
//                new MyUser(102L, "user", "123"),
//                new MyUser(103L, "user2", "pwd2"),
//                new MyUser(104L, "user3", "pwd3")
//        ).collect(Collectors.toList());
//        repository.saveAll(users);
//    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*")
                        .allowCredentials(true);
            }
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(FinalProjectApplication.class, args);

    }

private StockApiService stockApiService;

    @Override
    public void run(String... args) throws Exception {
//        MyUser myUser = new MyUser(2L, "user", "123");
//myUserRepository.save(myUser);


    }

}
