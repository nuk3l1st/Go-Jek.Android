package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class dk
  extends aj
{
  private static final String ID = a.aj.toString();
  private static final String apf = b.bw.toString();
  
  public dk()
  {
    super(ID, new String[] { apf });
  }
  
  public d.a C(Map<String, d.a> paramMap)
  {
    return di.u(di.j((d.a)paramMap.get(apf)).toUpperCase());
  }
  
  public boolean nN()
  {
    return true;
  }
}


/* Location:              /Users/michael/Downloads/dex2jar-2.0/GO_JEK.jar!/com/google/android/gms/tagmanager/dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */