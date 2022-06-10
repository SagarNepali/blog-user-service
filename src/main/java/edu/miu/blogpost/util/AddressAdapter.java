package edu.miu.blogpost.util;

import edu.miu.blogpost.domain.Address;
import edu.miu.blogpost.dto.AddressDTO;

public class AddressAdapter {
    public static Address addressDtoToaddress(AddressDTO addressDTO){
        Address newAddress = new Address();
        newAddress.setState(addressDTO.getState());
        newAddress.setCity(addressDTO.getCity());
        newAddress.setStreet(addressDTO.getStreet());
        newAddress.setZip(addressDTO.getZip());

        return newAddress;
    }

    public static AddressDTO addressToAddressDto(Address address){
        AddressDTO newAddressDto = new AddressDTO();
        newAddressDto.setCity(address.getCity());
        newAddressDto.setStreet(address.getStreet());
        newAddressDto.setState(address.getState());
        newAddressDto.setZip(address.getZip());

        return newAddressDto;
    }
}
