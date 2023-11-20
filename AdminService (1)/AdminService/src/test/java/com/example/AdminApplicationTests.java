package com.example;

 

 

import static org.junit.jupiter.api.Assertions.assertEquals;

 

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

 

 

import java.util.stream.Collectors;
import java.util.stream.Stream;

 

 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

 

 

import com.example.exception.TrainIdNotFoundException;
import com.example.models.Admin;
import com.example.repository.AdminRepository;
import com.example.service.AdminService;

 

 

@SpringBootTest
class AdminApplicationTests {
    @Autowired
    private AdminService adminService;

 

 

 



  @MockBean
    private AdminRepository adminDetailsRepository;
    @Test
    public void showallTrainsTest() throws TrainIdNotFoundException {
     when(adminDetailsRepository.findAll()).thenReturn( Stream
             .of(new Admin("10000",",MYS-EXP","Myld","Mysore")).collect(Collectors.toList()));
            assertEquals(1,adminService.showalltrains().size());
    }
    @Test
    public void getTrainbyidTest() throws TrainIdNotFoundException{
        String id="10000";
        try {
            adminService.getbytrainid(id);
            }
        catch(TrainIdNotFoundException e) {
            System.out.println(e);

        }
    }

 

    @Test
    public void addTrainDetailsTest() throws TrainIdNotFoundException{
          Admin admin=new Admin("10000",",MYS-EXP","Myld","Mysore");
          when(adminDetailsRepository.insert(admin)).thenReturn(admin);
          assertEquals(admin, adminService.addTrain(admin));
      }

 

   @Test
    public Admin updateTrainDetailsTest() throws TrainIdNotFoundException {
        Admin admin=new Admin("10000",",MYS-EXP","Myld","Mysore"); 
    when(adminDetailsRepository.save(admin)).thenReturn(admin);
    assertEquals(admin,adminService.updateTrain(admin));
    return admin;
    }

 

    @Test
    public Admin deleteTrainDetails() throws TrainIdNotFoundException {
        Admin admin=new Admin("10000",",MYS-EXP","Myld","Mysore");
        adminService.deleteTrain("1");
    verify(adminDetailsRepository,times(1)).delete(admin);
    return admin;
    }

 

 

}