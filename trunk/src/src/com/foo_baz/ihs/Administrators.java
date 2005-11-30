package com.foo_baz.ihs;
import com.foo_baz.v_q.ivqPackage.error;

public interface Administrators
{
  public abstract error addAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;

  public abstract error deleteAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;

  public abstract error updateAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;
  
  public abstract error getAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;

  public abstract error getAdministrators(java.util.ArrayList administrators) throws Exception;

}

