package com.example.dio.Service;

import com.example.dio.dto.request.RegistrationRequest;
import com.example.dio.dto.request.UserRequest;
import com.example.dio.dto.response.UserResponse;

public interface UserService  {
    /**
     * This method is used to register the User data.
     *It takes RegistrationRequest object as a parameter
     * @param registrationRequest  it consist of data such as Username,email,password,role.
     * @return the object of Registration request.
     * */
    UserResponse registerUser(RegistrationRequest registrationRequest);

    /**
     * It is used to get the user based on userid
     * @param userid passed to find the user data .
     * @exception throws userNotFoundByIdException of the userid passed is not present in the database.
     * @return UserResponse object.
     * */
    UserResponse findUserById(Long userid);

    /**
     * This method used to update the user details using input as userid , UserRequest object
     * @param userid specifies which user details must me changed
     * @param request object of UserRequest class present in dto
     * @return UserResponse Object
     */
    UserResponse updateUserById(Long userid, UserRequest request);
}

