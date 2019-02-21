package nathan.todolist.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {
    public static final String DISPATCHER_NAME = "dispatcher";
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        //springframework
        DispatcherServlet dispatcher = new DispatcherServlet(context);

        //javax.servlet
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_NAME, dispatcher);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
