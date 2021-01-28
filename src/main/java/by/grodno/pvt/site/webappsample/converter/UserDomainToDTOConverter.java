package by.grodno.pvt.site.webappsample.converter;

import by.grodno.pvt.site.webappsample.domain.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import by.grodno.pvt.site.webappsample.dto.UserDTO;

@Component
public class UserDomainToDTOConverter implements Converter<User, UserDTO> {

	@Override
	public UserDTO convert(User source) {
		UserDTO userDto = new UserDTO();
		userDto.setId(source.getId());
		userDto.setFirstName(source.getFirstName());
		userDto.setLastName(source.getLastName());
		userDto.setPhoneNumber(source.getPhoneNumber());
		userDto.setRole(source.getRole());
		return userDto;
	}

}
