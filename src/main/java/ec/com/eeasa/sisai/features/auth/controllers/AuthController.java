package ec.com.eeasa.sisai.features.auth.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.com.eeasa.sisai.features.auth.dtos.AuthRequest;
import ec.com.eeasa.sisai.features.auth.dtos.AuthResponse;
import ec.com.eeasa.sisai.features.auth.services.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticacion", description = "API para autenticarse")
public class AuthController {

    private final AuthenticationService authService;

    @PostMapping("/login")
    @Operation(summary = "Iniciar sesión", description = "Inicia sesión en el sistema")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
