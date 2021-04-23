package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.*;
import dmacc.repository.*;

@Controller
public class RosterController {
	
    @Autowired
    RosterRepository repo;

    @GetMapping({"/", "/viewRoster"})
    public String viewAllPlayers( Model model) {
        if (repo.findAll().isEmpty()) {
            return addNewPlayer(model);
        }
        model.addAttribute("rosters", repo.findAll());
        return "footballRosters";
    }

    @GetMapping("/inputPlayer")
    public String addNewPlayer(Model model) {
        Roster r = new Roster();
        model.addAttribute("newPlayer", r);
        return "rosterInput";
    }

    @PostMapping("/inputPlayer")
    public String addNewPlayer( @ModelAttribute Roster r, Model model) {
    	repo.save(r);
        return viewAllPlayers(model);
    }

    @GetMapping("/edit/{id}")
    public String showUpdatePlayer( @PathVariable("id") long id, Model model) {
        Roster r = repo.findById(id).orElse(null);
        model.addAttribute("newPlayer", r);
        return "rosterInput";
    }

    @PostMapping("/update/{id}")
    public String updatePlayer(Roster r, Model model) {
        repo.save(r);
        return viewAllPlayers(model);
    }

    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable("id") long id, Model model) {
        repo.findById(id).ifPresent(repo :: delete);
        return viewAllPlayers(model);
    }

}
