package wjc.springboot.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-11-05 17:34
 **/
@RestController
public class PersonController {

    private Map<String, User> userMap = new HashMap<>();

    /**
     * User register with whose username and password
     *
     * @param user
     * @return Success message
     * @throws ServletException
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody User user) throws ServletException {
        // Check if username and password is null
        if (user.getUsername() == "" || user.getUsername() == null
                || user.getPassword() == "" || user.getPassword() == null) {
            throw new ServletException("Username or Password invalid!");
        }

        // Check if the username is used
        if (userMap.containsKey(user.getUsername())) {
            throw new ServletException("Username is used!");
        }

        userMap.put(user.getUsername(), user);
        return "Register Success!";
    }

    /**
     * Check user`s login info, then create a jwt token returned to front end
     *
     * @param reqPerson
     * @return jwt token
     * @throws ServletException
     */
    @PostMapping("/login")
    public String login(@RequestBody() User reqPerson) throws ServletException {
        // Check if username and password is null

        if (StringUtils.isEmpty(reqPerson.getUsername())
                || StringUtils.isEmpty(reqPerson.getPassword())) {
            throw new ServletException("Please fill in username and password");
        }

        // Check if the username is used
        if (!userMap.containsKey(reqPerson.getUsername())
                || !userMap.get(reqPerson.getUsername()).equals(reqPerson)) {
            throw new ServletException("Please fill in username and password");
        }

        // Create Twt token

        String jwt = Jwts.builder()
                .setSubject(reqPerson.getUsername())
                .claim("roles", "member")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact();


        System.out.println(jwt);

        return jwt;
    }
}
