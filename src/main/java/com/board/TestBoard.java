package com.board;

import com.board.config.WebAppConfig;
import com.board.service.UserService;
import com.board.service.impl.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestBoard {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebAppConfig.class);
        UserService userService = context.getBean(UserServiceImpl.class);
        System.out.println(userService.findById(1));
        //userService.findById(1);


        // CATEGORY SERVICE
/*

        CategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());

        Category category = new Category();
        category.setCategoryName("Category name");

        //categoryService.save(category);                                                   //save Category
        //System.out.println("Category  : "+ categoryService.findById(10).toString());      //GET Category
        Category updateCat = categoryService.findById(10);
        updateCat.setCategoryName("Updated category name");                                //Update Category
        categoryService.update(updateCat);
        //categoryService.deleteById(10);                                                   //DELETE CATEGORY

*/

        //------------------------------------------------------------------------------------------------------------

        // USER SERVICE

/*

        UserService userService = new UserServiceImpl(new UserRepositoryImpl());

        User user = new User();

        user.setFirstName("First name");
        user.setLastName("Last name");
        user.setLogin("First user's login");
        user.setPassword("First user's");


        Email email = new Email();
        email.setEmail("firstEmail@gmail.com");
        user.setEmail(email);


        Phone phone = new Phone();
        phone.setNumber("1234567");
        phone.setOperator("097");
        user.getPhones().add(phone);



        Address address = new Address();
        address.setCity("Lviv");
        address.setStreet("Zelena");
        address.setRegion("Lviv region");
        address.setPostCode(11111);
        user.setAddress(address);

        //userService.save(user);                                                        //SAVE USER
        //System.out.println("User : " + userService.findById(1).toString());            //GET USER

        //User updatedUser = userService.findById(6);

        *//*updatedUser.setEmail(email);
        userService.update(updatedUser);*//*                                               //UPDATE USER's EMAIL


         *//*updatedUser.getPhones().add(phone);
        userService.update(updatedUser);*//*                                               //UPDATE USER's PHONE


         *//*updatedUser.setAddress(address);
        userService.update(updatedUser);*//*                                               //UPDATE USER's ADDRESS

        //userService.deleteById(17);                                                     //DELETE USER BY ID


 */

        //----------------------------------------------------------------------------------------------------------

        // Announcement Service
/*
        AnnouncementService announcementService = new AnnouncementServiceImpl(new AnnouncementRepositoryImpl());
        CategoryService categoryService = new CategoryServiceImpl(new CategoryRepositoryImpl());

        Announcement announcement = new Announcement();
        Category category = new Category();
        category.setCategoryName("Category name");
        announcement.setCategory(category);
        announcement.setTitle("Title");
        announcement.setPrice(100);
        announcement.setText("Description");


        categoryService.save(category);
        announcementService.save(announcement);                                                   //SAVE ANNOUNCEMENT
        //System.out.println(" Announcement :  "  + announcementService.findById(13).toString());   //GET  ANNOUNCEMENT

        Announcement newAnnouncement = announcementService.findById(13);
        newAnnouncement.setPrice(150);
        newAnnouncement.setTitle("New Title ");
        announcementService.update(newAnnouncement);                                            //UPDATE ANNOUNCEMENT
        announcementService.deleteById(13);                                                     //DELETE ANNOUNCEMENT
        categoryService.deleteById(12);

 */


    }
}

/*
 * CRUD
 * SQL scripts
 *
 * Create all tables, ALTER users SET AUTO_INCREMENT = 1;
 * */
