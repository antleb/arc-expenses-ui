package arc.expenses.controller;

import gr.athenarc.domain.Project;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import arc.expenses.service.ProjectServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/project")
@Api(description = "Project API  ",  tags = {"Manage projects"})
public class ProjectController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    ProjectServiceImpl projectService;


    @RequestMapping(value =  "/getById/{id}", method = RequestMethod.GET)
    public Project getById(@PathVariable("id") String id) {
        return projectService.get(id);
    }

    @RequestMapping(value =  "/getByAcronym/{acronym}/{institute}", method = RequestMethod.GET)
    public Project getByAcronym(@PathVariable("acronym") String acronym,
                                @PathVariable("institute") String institute) {
        return projectService.getByAcronym(acronym,institute);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    Project addProject(@RequestBody Project project) {
        return projectService.add(project);
    }

    @RequestMapping(value =  "/getAll", method = RequestMethod.GET)
    public List<Project> getAll() {
        return null;
    }

    @RequestMapping(value =  "/getAllProjectNames", method = RequestMethod.GET)
    public List<String> getAllProjectNames() {
        return projectService.getAllProjectNames();
    }
}