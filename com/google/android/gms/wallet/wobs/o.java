package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class o
  implements Parcelable.Creator<n>
{
  static void a(n paramn, Parcel paramParcel, int paramInt)
  {
    paramInt = b.D(paramParcel);
    b.c(paramParcel, 1, paramn.getVersionCode());
    b.a(paramParcel, 2, paramn.auM, false);
    b.a(paramParcel, 3, paramn.description, false);
    b.H(paramParcel, paramInt);
  }
  
  public n dN(Parcel paramParcel)
  {
    String str2 = null;
    int j = a.C(paramParcel);
    int i = 0;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = a.B(paramParcel);
      switch (a.aD(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        i = a.g(paramParcel, k);
        break;
      case 2: 
        str1 = a.o(paramParcel, k);
        break;
      case 3: 
        str2 = a.o(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new a.a("Overread allowed size end=" + j, paramParcel);
    }
    return new n(i, str1, str2);
  }
  
  public n[] fQ(int paramInt)
  {
    return new n[paramInt];
  }
}


/* Location:              /Users/michael/Downloads/dex2jar-2.0/GO_JEK.jar!/com/google/android/gms/wallet/wobs/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */