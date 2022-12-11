package app.service;

import app.dto.AddUserDTO;
import app.dto.AuthUserDTO;
import app.entity.RedisUser;
import app.redis.RedisUtility;
import app.repository.UserRepository;
import app.response.GenericResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private RedisUtility redisUtility;

    public GenericResponse addUser(AddUserDTO addUserDTO) {
        RedisUser user = new RedisUser();
        user.setEmailId(addUserDTO.getEmailId());
        user.setPassword(addUserDTO.getPassword());

        if (userRepository.findByEmailIdAndPassword(addUserDTO.getEmailId(), addUserDTO.getPassword()).isPresent()) {
            return new GenericResponse("User already exist!", addUserDTO.getEmailId());
        }

        return new GenericResponse("User was registered.", userRepository.save(user));
    }

    public GenericResponse authUser(AuthUserDTO authUserDTO) {

        AuthUserDTO existingUserDTO = redisUtility.getValue(authUserDTO.getEmailId());

        if (existingUserDTO == null) {
            if (userRepository.findByEmailIdAndPassword(authUserDTO.getEmailId(), authUserDTO.getPassword()).isPresent()) {
                redisUtility.setValue(authUserDTO.getEmailId(), authUserDTO);
                return new GenericResponse("Getting data from database", authUserDTO);
            }
            return new GenericResponse("No value found", authUserDTO);
        }

        return new GenericResponse("Getting value from Redis", existingUserDTO);
        }
    }
