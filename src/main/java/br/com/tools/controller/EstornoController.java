package br.com.tools.controller;

import br.com.tools.services.EstornoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/estornos")
public class EstornoController {

    private final EstornoService estornoService;

}
