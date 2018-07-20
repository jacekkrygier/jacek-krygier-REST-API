package com.crud.tasks.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AdminConfig {
    @Value("${admin.mail}")
    private String adminMail;

    @Value("${admin.name}")
    private String adminName;
    @Value("${info.app.company.name}")
    private String companyName;

    @Value("${info.app.administrator.address.street}")
    private String companyStreet;

    @Value("${info.app.administrator.address.number}")
    private String companyStreetNumber;

    @Value("${info.app.company.phone}")
    private String companyPhone;

    @Value("${info.app.company.email}")
    private String companyEmail;
}
