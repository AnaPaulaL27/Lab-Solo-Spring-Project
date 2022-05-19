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
import java.util.List;

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

        Feedback customerFeedback1 = new Feedback(LocalDate.of(2022, Month.JANUARY, 21), "Katie Hull",
                "Tried out this place for the first time. Not too bad. Enjoyed the big meal platter that gives you a " +
                        "variety of food to relish from. It's a stop over for lunch with friends kinda place. Definitely" +
                        " revisiting again.", 4, nandoca1);


        Feedback customerFeedback2 = new Feedback(LocalDate.of(2022, Month.FEBRUARY, 12), "Bruno J'Oliver",
                "Beautiful place, friendly staff and delicious food. As good as all the other Nando’s.",
                4, nandoca2);


        Feedback customerFeedback3 = new Feedback(LocalDate.of(2022, Month.FEBRUARY, 12), "Chloe May",
                "Great food for a good price! The chicken is really out of this world and you can eat without" +
                        " fear. Remember that you can use some very tasty sauces to let your dish even better!",
                4, nandoca3);

        Feedback customerFeedback4 = new Feedback(LocalDate.of(2022, Month.FEBRUARY, 13), "Taco Lizard",
                "As we entered the 'restaurant', we were greeted by a non-smiling staff member who abrasively " +
                        "admonished us to sit downstairs.",
                1, nandoca4);


        Feedback customerFeedback5 = new Feedback(LocalDate.of(2022, Month.FEBRUARY, 2), "Amanda T",
                "Asked for a simple fork... took half an hour for the staff to get me one... Should've eaten at home!",
                1, nandoca5);


        Feedback customerFeedback6 = new Feedback(LocalDate.of(2022, Month.MARCH, 9), "Nichole Smith",
                "I like Nandos you cant normally go wrong, but I have had better than the one in Covent Garden." +
                        "  There was a slight issue with the food and to be honest the attitude of the staff was not what " +
                        "I expected, replacement was given but only as an after thought i think.  Being Friday night it " +
                        "was very busy but has put me off wanting to go there again",
                3, nandoca6);

        Feedback customerFeedback7 = new Feedback(LocalDate.of(2022, Month.MARCH, 10), "John Mill",
                "After waiting half my break to be served. I had to cancel my order after I was advised, that " +
                        "I can not request the sections of chicken, I would like to eat.  I have requested specific pieces " +
                        "of chicken before at other Nando’s and found this not to be a problem.  If I could give 0 stars I would.",
                1, nandoca6);


        Feedback customerFeedback8 = new Feedback(LocalDate.of(2022, Month.APRIL, 11), "Kamal Ibra",
                "Service was great! Food tasty and the table was sanitised prior to being seated.",
                5, nandoca7);

        Feedback customerFeedback9 = new Feedback(LocalDate.of(2022, Month.APRIL, 12), "Brian",
                "Nice ambiance. Even better food. Anything you eat here is guaranteed to be tasty!",
                5, nandoca8);

        Feedback customerFeedback10 = new Feedback(LocalDate.of(2022, Month.MAY, 12), "Gill Gaffney",
                "Acceptable wait for a table at lunchtime in London, however the app didn't allow you to add " +
                        "certain drinks so had to queue again for around 10 minutes to add a drink to the order. " +
                        "In the restaurant's defence, as soon as I raised the matter, someone sorted it out very quickly." +
                        " Food was delicious and we were served in good time.",
                4, nandoca9);

        Feedback customerFeedback11 = new Feedback(LocalDate.of(2022, Month.MAY, 15), "Melissa Alveres",
                "I love eating at Nando’s in London and have never been disappointed the food is always piping " +
                        "hot and very tasty and well cooked the service was very attentive although we did eat just before the cinema.",
                5, nandoca10);

        Feedback customerFeedback12 = new Feedback(LocalDate.of(2022, Month.MAY, 15), "Nathan Miles",
                "Absolutely Amazinggggg!!!!! Lovely place to visit with the fam",
                5, nandoca11);

        Feedback customerFeedback13 = new Feedback(LocalDate.of(2022, Month.MAY, 16), "Cassie",
                "Lovely bunch of people and food! Yes to Nandosss! ",
                4, nandoca12);

        Feedback customerFeedback14 = new Feedback(LocalDate.of(2022, Month.MAY, 16), "Samira Abdullah",
                "well... my chicken was a little off this time, but other than that, great!",
                3, nandoca13);


        Feedback customerFeedback15 = new Feedback(LocalDate.of(2022, Month.MAY, 17), "Ebenezer Salvador",
                "Please... next time, I need more chips, and sauces. It's either that or I will be bringing my own!",
                3, nandoca14);

        Feedback customerFeedback16 = new Feedback(LocalDate.of(2022, Month.MAY, 17), "Bridget S.",
                "The small Nandino was to perfectionnn... my little one won't stop talking about it! Will definitely" +
                        "be coming here again, kudos to Nandos :)!",
                5, nandoca15);

        Feedback customerFeedback17 = new Feedback(LocalDate.of(2022, Month.MAY, 18), "Sam P.",
                "Lovely people! Well deserved rating!",
                5, nandoca15);


        //assigning feedback to the Nandoca

        nandoca1.setCustomerFeedback(List.of(customerFeedback1));

        nandoca2.setCustomerFeedback(List.of(customerFeedback2));

        nandoca3.setCustomerFeedback(List.of(customerFeedback3));

        nandoca4.setCustomerFeedback(List.of(customerFeedback4));

        nandoca5.setCustomerFeedback(List.of(customerFeedback5));

        nandoca6.setCustomerFeedback(List.of(customerFeedback6, customerFeedback7));

        nandoca7.setCustomerFeedback(List.of(customerFeedback8));

        nandoca8.setCustomerFeedback(List.of(customerFeedback9));

        nandoca9.setCustomerFeedback(List.of(customerFeedback10));

        nandoca10.setCustomerFeedback(List.of(customerFeedback11));

        nandoca11.setCustomerFeedback(List.of(customerFeedback12));

        nandoca12.setCustomerFeedback(List.of(customerFeedback13));

        nandoca13.setCustomerFeedback(List.of(customerFeedback14));

        nandoca14.setCustomerFeedback(List.of(customerFeedback15));

        nandoca15.setCustomerFeedback(List.of(customerFeedback16, customerFeedback17));


    }

}


