package arc.expenses.service;

import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.domain.Paging;
import eu.openminted.registry.core.exception.ResourceNotFoundException;
import gr.athenarc.domain.Institute;
import gr.athenarc.domain.Organization;
import gr.athenarc.domain.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("instituteService")
public class InstituteServiceImpl extends GenericService<Institute>{

    @Autowired
    CascadeService cascadeService;

    public InstituteServiceImpl() {
        super(Institute.class);
    }

    @Override
    public String getResourceType() {
        return "institute";
    }

    public Paging<Institute> getAllInstitutes(Authentication authentication) {
        FacetFilter filter = new FacetFilter();
        filter.setResourceType(getResourceType());

        filter.setKeyword("");
        filter.setFrom(0);
        filter.setQuantity(1000);

        Map<String,Object> sort = new HashMap<>();
        Map<String,Object> order = new HashMap<>();

        order.put("order","desc");
        sort.put("creation_date", order);
        filter.setOrderBy(sort);

        filter.setFrom(0);
        filter.setQuantity(20);
        return getAll(filter,authentication);
    }

    @Override
    public Institute update(Institute institute, Authentication authentication) throws ResourceNotFoundException {
        update(institute,institute.getId());
        cascadeService.cascadeAll(institute,authentication);
        return institute;
    }
}
