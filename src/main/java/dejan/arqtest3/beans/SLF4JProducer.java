/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dejan.arqtest3.beans;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JProducer {

  @Produces
  public Logger loggerProducer(InjectionPoint ip){
    return LoggerFactory.getLogger(
      ip.getMember().getDeclaringClass().getName());
  }
}
