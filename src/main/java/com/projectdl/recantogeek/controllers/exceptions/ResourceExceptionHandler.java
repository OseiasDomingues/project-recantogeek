package com.projectdl.recantogeek.controllers.exceptions;

import com.projectdl.recantogeek.services.exceptions.PageNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(PageNotFound.class)
    public ModelAndView pageNotFound(PageNotFound e, HttpServletRequest request){
        ModelAndView mv = new ModelAndView("error");
        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Page not found";
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        mv.addObject("error", err);
        return mv;
    }


}
