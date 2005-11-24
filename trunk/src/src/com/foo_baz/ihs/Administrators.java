package com.foo_baz.ihs;
import com.foo_baz.ihs.Error;

public interface Administrators
{
  public abstract Error addAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;

  public abstract Error deleteAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;

  public abstract Error updateAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;
  
  public abstract Error getAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;

  public abstract Error getAdministrators(java.util.ArrayList administrators) throws Exception;

}

