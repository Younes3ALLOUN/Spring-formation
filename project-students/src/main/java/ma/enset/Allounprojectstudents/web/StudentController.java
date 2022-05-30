package ma.enset.Allounprojectstudents.web;

import lombok.AllArgsConstructor;
import ma.enset.Allounprojectstudents.entities.Student;
import ma.enset.Allounprojectstudents.repositories.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class StudentController {
    private StudentRepository studentRepository;
    //******************************************************* main
    @GetMapping(path = "/user/main")
    public String getStudents(Model model,
                              @RequestParam(name= "page",defaultValue = "0") int page,
                              @RequestParam(name ="size",defaultValue = "5") int size,
                              @RequestParam(name = "keyword", defaultValue = "") String keyword){
        Page<Student> studentPage = studentRepository.findByFirstNameContains(keyword, PageRequest.of(page,size));
        model.addAttribute("students",studentPage.getContent());
        model.addAttribute("pages",new int[studentPage.getTotalPages()]);
        model.addAttribute("currentpage",page);
        model.addAttribute("keyword",keyword);
        return "mainstudent";
    }
    //**************************************************************home
    @GetMapping("/")
    public String home(){
        return "home";
    }
    //******************************************************************add
    @GetMapping(path = "/admin/formstudent")
    public String formstudent(Model model){
        model.addAttribute("student", new Student());

        return "formstudent";
    }
    //********************************************************************delete
    //@DeleteMapping("/delete/{id}")
    @GetMapping ("/admin/delete")
    public String delete( Long id, String keyword, int page){
        studentRepository.deleteById(id);
        System.out.println(page);
        return "redirect:/user/main?page="+page+"&keyword="+keyword;
    }
    //***************************************************save
    @PostMapping(path="/admin/save")
    public String save(Model model, @Valid Student student, BindingResult bindingResult,
                       @RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "") String keyword){
        if(bindingResult.hasErrors()){
            return "formstudent";
        }
        studentRepository.save(student);
        return "redirect:/user/main?page="+page+"&keyword="+keyword;
    }
    //********************************** edit
    @GetMapping("/admin/edit")
    public String edite(Model model,Long id,String keyword ,int page){
        Student student = studentRepository.findById(id).orElse(null);

        if(student== null)throw new RuntimeException("student n'existe pas");
        model.addAttribute("student",student);
        model.addAttribute("keyword",keyword);
        model.addAttribute("currentpage",page);

        return "edite";
    }
}
