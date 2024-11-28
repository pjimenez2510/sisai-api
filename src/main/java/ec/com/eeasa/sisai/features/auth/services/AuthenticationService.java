package ec.com.eeasa.sisai.features.auth.services;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ec.com.eeasa.sisai.features.auth.dtos.AuthRequest;
import ec.com.eeasa.sisai.features.auth.dtos.AuthResponse;
import ec.com.eeasa.sisai.features.auth.entities.CustomUserDetails;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JwtService jwtService;
    private final CustomUserDetailsService userDetailsService;

    public AuthResponse authenticate(AuthRequest request) {
        CustomUserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails,
                null,
                userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authToken);

        String jwt = jwtService.generateToken(userDetails);
        List<String> permissions = userDetails.getPermisos()
                .stream()
                .map(p -> p.getRecurso() + "_" + p.getAccion())
                .collect(Collectors.toList());

        return new AuthResponse(jwt, permissions);
    }
}
