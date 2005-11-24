package com.foo_baz.ihs;

public interface Administrators
{
  public abstract com.foo_baz.ihs.Error addAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;

  public abstract com.foo_baz.ihs.Error deleteAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;

  public abstract com.foo_baz.ihs.Error updateAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;
  
  public abstract com.foo_baz.ihs.Error getAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;

  public abstract com.foo_baz.ihs.Error getAdministrators(java.util.ArrayList administrators) throws Exception;

}

