package com.paypal;

import com.paypal.assignment3.persistence.PersistenceManagerFactory;
import com.paypal.assignment3.resources.User;
import com.paypal.assignment3.resources.UserResource;

import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
        UserResource userResource = new UserResource(PersistenceManagerFactory.getInstance().createPersistanceManager(PersistenceManagerFactory.PersistanceType.IN_MEMORY));
        User user = new User();
        user.setAsset("asset");
        user.setLoginTime(String.valueOf(new Date()));
        user.addIpAddress("127.0.0.1");
        String key = userResource.create(user);
        System.out.println ("user saved with key : " + key);
        User attachedUser = userResource.getUser(key);
        System.out.println("fetched user : " + attachedUser);
        attachedUser.addIpAddress("100.100.100.100");
        attachedUser = userResource.update(key, attachedUser);
        System.out.println(" After new Ip addition : " + attachedUser);
        System.out.println("anomaly detected for ip address 100.100.100.100 : " + userResource.detectAnomaly(key, "100.100.100.100"));
        System.out.println("anomaly detected for ip address 127.0.0.1 : " + userResource.detectAnomaly(key, "127.0.0.1"));
        System.out.println("anomaly detected for ip address 120.100.100.100 : " + userResource.detectAnomaly(key, "120.100.100.100"));
    }
}
