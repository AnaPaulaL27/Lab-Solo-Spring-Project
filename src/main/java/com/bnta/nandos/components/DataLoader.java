package com.bnta.nandos.components;

import com.bnta.nandos.models.Feedback;
import com.bnta.nandos.models.Nandoca;
import com.bnta.nandos.repositories.FeedbackRepository;
import com.bnta.nandos.repositories.NandocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

//We need component annotation to make the class visible to spring
//@Component-  allows Spring to automatically detect our custom beans.
// i.e., without having to write any explicit code, Spring will: Scan our application for classes
// annotated with @Component.
// Instantiate them and inject any specified dependencies into them.
@Component
public class DataLoader  implements ApplicationRunner {

    // Autowired- apply it to property fields, setter methods, and/or constructors.
    // tells Spring 'automatically inject the appropriate dependency here'.
    //it glues layers of application

    @Autowired
    private NandocaRepository nandocaRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    //need override
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // adding some Nandocas

        Nandoca nandoca1 = new Nandoca("Sandra", "Matos", LocalDate.of(1997, Month.DECEMBER,
                12), 3, 12345);

        Nandoca nandoca2 = new Nandoca("Carlos", "D'silva", LocalDate.of(1982, Month.JANUARY,
                28), 1, 67891);


        Nandoca nandoca3 = new Nandoca("Susana", "Pinto", LocalDate.of(1991, Month.OCTOBER,
                7), 5,23456 );

        Nandoca nandoca4 = new Nandoca("Patricia", "Guimaraes", LocalDate.of(1978, Month.APRIL,
                1), 7, 63726);

        Nandoca nandoca5 = new Nandoca("Diogo", "Castro", LocalDate.of(1984, Month.JULY,
                17), 4, 82355);

        Nandoca nandoca6 = new Nandoca("Leila", "Hocksteal", LocalDate.of(1999, Month.SEPTEMBER,
                8), 2, 77881);


        Nandoca nandoca7 = new Nandoca("Heather", "Wright", LocalDate.of(1993, Month.JUNE,
                29), 1,73855 );

        Nandoca nandoca8 = new Nandoca("Benjamin", "Blackman", LocalDate.of(1957, Month.FEBRUARY,
                14), 6, 17836);

        Nandoca nandoca9 = new Nandoca("Jane", "Viega", LocalDate.of(1, Month.APRIL,
                4), 1, 42544);

        Nandoca nandoca10 = new Nandoca("Precious", "Knight", LocalDate.of(1994, Month.JANUARY,
                30), 4, 67857);


        Nandoca nandoca11 = new Nandoca("Ana", "Lima", LocalDate.of(1992, Month.FEBRUARY,
                9), 3,95405 );

        Nandoca nandoca12 = new Nandoca("Luke", "Grey", LocalDate.of(1970, Month.DECEMBER,
                2), 5, 74232);

        Nandoca nandoca13 = new Nandoca("Precious", "Knight", LocalDate.of(1998, Month.APRIL,
                1), 2, 87847);


        Nandoca nandoca14 = new Nandoca("Pedro", "Santos", LocalDate.of(1992, Month.FEBRUARY,
                5), 3,93405 );

        Nandoca nandoca15 = new Nandoca("Jessica", "Palmer", LocalDate.of(1992, Month.MARCH,
                2), 7, 84232);




        //adding some Feedback

        Feedback feedback1 = new Feedback(LocalDate.of(2022, Month.JANUARY, 21, "Katie Hull", ))

    }







}


