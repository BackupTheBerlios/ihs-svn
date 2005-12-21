package com.foo_baz.ihs;

import com.foo_baz.util.OperationStatus;

public interface Administrators
{
  public abstract OperationStatus addAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;

  public abstract OperationStatus deleteAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;

  public abstract OperationStatus updateAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;
  
  public abstract OperationStatus getAdministrator(com.foo_baz.ihs.Administrator administrator) throws Exception;

  public abstract OperationStatus getAdministrators(java.util.ArrayList administrators) throws Exception;

}

