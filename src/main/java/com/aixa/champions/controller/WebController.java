package com.aixa.champions.controller;
import com.aixa.champions.dto.PredictionForm;import com.aixa.champions.service.*;
import jakarta.validation.Valid;import org.springframework.stereotype.Controller;import org.springframework.ui.Model;import org.springframework.validation.BindingResult;import org.springframework.web.bind.annotation.*;
@Controller public class WebController {
private final MatchService matches;private final PredictionService predictions;
public WebController(MatchService matches,PredictionService predictions){this.matches=matches;this.predictions=predictions;}
@GetMapping("/") public String home(Model model){model.addAttribute("matches",matches.all());model.addAttribute("predictions",predictions.all());model.addAttribute("form",new PredictionForm());return "index";}
@PostMapping("/predictions") public String add(@Valid @ModelAttribute("form") PredictionForm form,BindingResult errors,Model model){if(errors.hasErrors()){model.addAttribute("matches",matches.all());model.addAttribute("predictions",predictions.all());model.addAttribute("error","Completa correctamente el nombre, partido y marcadores entre 0 y 20.");return "index";}try{predictions.save(form);}catch(IllegalArgumentException ex){model.addAttribute("matches",matches.all());model.addAttribute("predictions",predictions.all());model.addAttribute("error",ex.getMessage());return "index";}return "redirect:/#predicciones";}
}
