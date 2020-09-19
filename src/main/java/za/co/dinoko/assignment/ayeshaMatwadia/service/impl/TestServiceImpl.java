package za.co.dinoko.assignment.ayeshaMatwadia.service.impl;

import org.springframework.stereotype.Service;
import za.co.dinoko.assignment.ayeshaMatwadia.service.TestService;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String helloWorld() {
        return "Hello There";
    }
}
