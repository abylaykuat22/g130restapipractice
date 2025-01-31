package kz.bitlab.g130restapipractice.controller;

import kz.bitlab.g130restapipractice.entity.Subject;
import kz.bitlab.g130restapipractice.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

}
