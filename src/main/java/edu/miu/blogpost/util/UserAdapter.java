package edu.miu.blogpost.util;


import edu.miu.blogpost.domain.Address;
import edu.miu.blogpost.domain.User;
import edu.miu.blogpost.dto.UserDTO;

public class UserAdapter {
    public static User userDtoToUser(UserDTO userDTO){
        User newUser = new User();
        Address newAddress = AddressAdapter.addressDtoToaddress(userDTO.getAddressDTO());

        newUser.setFirstName(userDTO.getFirstName());
        newUser.setLastName(userDTO.getLastName());
        newUser.setAddress(newAddress);
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(userDTO.getPassword());
        newUser.setUsername(userDTO.getUsername());

        return newUser;
    }

    public static UserDTO userToUserDto(User user){
        UserDTO newUserDto = new UserDTO();

        newUserDto.setAddressDTO(AddressAdapter.addressToAddressDto(user.getAddress()));

        newUserDto.setId(user.getId());
        newUserDto.setUsername(user.getUsername());
        newUserDto.setEmail(user.getEmail());
        newUserDto.setFirstName(user.getFirstName());
        newUserDto.setLastName(user.getLastName());
        newUserDto.setPassword(user.getPassword());

        return newUserDto;
    }
}
