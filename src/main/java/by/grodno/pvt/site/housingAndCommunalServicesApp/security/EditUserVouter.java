package by.grodno.pvt.site.housingAndCommunalServicesApp.security;


import by.grodno.pvt.site.housingAndCommunalServicesApp.domain.User;
import by.grodno.pvt.site.housingAndCommunalServicesApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("editUserVouter")
public class EditUserVouter {
    @Autowired
    private UserService service;

    public boolean checkUserId(Authentication authentication, Integer id) {
        User user = service.getUser(id);

        String username = ((org.springframework.security.core.userdetails.User)authentication.getPrincipal()).getUsername();

        return username.equals(user.getEmail());
    }
}
