package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R.string;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.dynamic.h;
import com.google.android.gms.internal.or;
import com.google.android.gms.internal.os.a;
import com.google.android.gms.internal.oz;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.TraceMachine;

@Instrumented
public final class SupportWalletFragment
  extends Fragment
  implements TraceFieldInterface
{
  private final Fragment Lt = this;
  private b atQ;
  private final h atR = h.a(this);
  private final c atS = new c(null);
  private a atT = new a(this);
  private WalletFragmentOptions atU;
  private WalletFragmentInitParams atV;
  private MaskedWalletRequest atW;
  private MaskedWallet atX;
  private Boolean atY;
  private boolean mCreated = false;
  
  public static SupportWalletFragment newInstance(WalletFragmentOptions paramWalletFragmentOptions)
  {
    SupportWalletFragment localSupportWalletFragment = new SupportWalletFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extraWalletFragmentOptions", paramWalletFragmentOptions);
    localSupportWalletFragment.Lt.setArguments(localBundle);
    return localSupportWalletFragment;
  }
  
  public int getState()
  {
    if (this.atQ != null) {
      return b.a(this.atQ);
    }
    return 0;
  }
  
  public void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
  {
    if (this.atQ != null)
    {
      b.a(this.atQ, paramWalletFragmentInitParams);
      this.atV = null;
    }
    do
    {
      return;
      if (this.atV != null) {
        break;
      }
      this.atV = paramWalletFragmentInitParams;
      if (this.atW != null) {
        Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
      }
    } while (this.atX == null);
    Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
    return;
    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.atQ != null) {
      b.a(this.atQ, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    TraceMachine.startTracing("SupportWalletFragment");
    try
    {
      TraceMachine.enterMethod(this._nr_trace, "SupportWalletFragment#onCreate", null);
      super.onCreate(paramBundle);
      if (paramBundle != null)
      {
        paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        WalletFragmentInitParams localWalletFragmentInitParams = (WalletFragmentInitParams)paramBundle.getParcelable("walletFragmentInitParams");
        if (localWalletFragmentInitParams != null)
        {
          if (this.atV != null) {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
          }
          this.atV = localWalletFragmentInitParams;
        }
        if (this.atW == null) {
          this.atW = ((MaskedWalletRequest)paramBundle.getParcelable("maskedWalletRequest"));
        }
        if (this.atX == null) {
          this.atX = ((MaskedWallet)paramBundle.getParcelable("maskedWallet"));
        }
        if (paramBundle.containsKey("walletFragmentOptions")) {
          this.atU = ((WalletFragmentOptions)paramBundle.getParcelable("walletFragmentOptions"));
        }
        if (paramBundle.containsKey("enabled")) {
          this.atY = Boolean.valueOf(paramBundle.getBoolean("enabled"));
        }
        this.mCreated = true;
        this.atS.onCreate(paramBundle);
        TraceMachine.exitMethod();
        return;
      }
    }
    catch (NoSuchFieldError localNoSuchFieldError)
    {
      for (;;)
      {
        TraceMachine.enterMethod(null, "SupportWalletFragment#onCreate", null);
        continue;
        if (this.Lt.getArguments() != null)
        {
          WalletFragmentOptions localWalletFragmentOptions = (WalletFragmentOptions)this.Lt.getArguments().getParcelable("extraWalletFragmentOptions");
          if (localWalletFragmentOptions != null)
          {
            localWalletFragmentOptions.aa(this.Lt.getActivity());
            this.atU = localWalletFragmentOptions;
          }
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    try
    {
      TraceMachine.enterMethod(this._nr_trace, "SupportWalletFragment#onCreateView", null);
      paramLayoutInflater = this.atS.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      TraceMachine.exitMethod();
      return paramLayoutInflater;
    }
    catch (NoSuchFieldError localNoSuchFieldError)
    {
      for (;;)
      {
        TraceMachine.enterMethod(null, "SupportWalletFragment#onCreateView", null);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mCreated = false;
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    if (this.atU == null) {
      this.atU = WalletFragmentOptions.a(paramActivity, paramAttributeSet);
    }
    paramAttributeSet = new Bundle();
    paramAttributeSet.putParcelable("attrKeyWalletFragmentOptions", this.atU);
    this.atS.onInflate(paramActivity, paramAttributeSet, paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.atS.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.atS.onResume();
    FragmentManager localFragmentManager = this.Lt.getActivity().getSupportFragmentManager();
    Fragment localFragment = localFragmentManager.findFragmentByTag("GooglePlayServicesErrorDialog");
    if (localFragment != null)
    {
      localFragmentManager.beginTransaction().remove(localFragment).commit();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.Lt.getActivity()), this.Lt.getActivity(), -1);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
    this.atS.onSaveInstanceState(paramBundle);
    if (this.atV != null)
    {
      paramBundle.putParcelable("walletFragmentInitParams", this.atV);
      this.atV = null;
    }
    if (this.atW != null)
    {
      paramBundle.putParcelable("maskedWalletRequest", this.atW);
      this.atW = null;
    }
    if (this.atX != null)
    {
      paramBundle.putParcelable("maskedWallet", this.atX);
      this.atX = null;
    }
    if (this.atU != null)
    {
      paramBundle.putParcelable("walletFragmentOptions", this.atU);
      this.atU = null;
    }
    if (this.atY != null)
    {
      paramBundle.putBoolean("enabled", this.atY.booleanValue());
      this.atY = null;
    }
  }
  
  public void onStart()
  {
    ApplicationStateMonitor.getInstance().activityStarted();
    super.onStart();
    this.atS.onStart();
  }
  
  public void onStop()
  {
    ApplicationStateMonitor.getInstance().activityStopped();
    super.onStop();
    this.atS.onStop();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.atQ != null)
    {
      b.a(this.atQ, paramBoolean);
      this.atY = null;
      return;
    }
    this.atY = Boolean.valueOf(paramBoolean);
  }
  
  public void setOnStateChangedListener(OnStateChangedListener paramOnStateChangedListener)
  {
    this.atT.a(paramOnStateChangedListener);
  }
  
  public void updateMaskedWallet(MaskedWallet paramMaskedWallet)
  {
    if (this.atQ != null)
    {
      b.a(this.atQ, paramMaskedWallet);
      this.atX = null;
      return;
    }
    this.atX = paramMaskedWallet;
  }
  
  public void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
  {
    if (this.atQ != null)
    {
      b.a(this.atQ, paramMaskedWalletRequest);
      this.atW = null;
      return;
    }
    this.atW = paramMaskedWalletRequest;
  }
  
  public static abstract interface OnStateChangedListener
  {
    public abstract void onStateChanged(SupportWalletFragment paramSupportWalletFragment, int paramInt1, int paramInt2, Bundle paramBundle);
  }
  
  static class a
    extends os.a
  {
    private SupportWalletFragment.OnStateChangedListener atZ;
    private final SupportWalletFragment aua;
    
    a(SupportWalletFragment paramSupportWalletFragment)
    {
      this.aua = paramSupportWalletFragment;
    }
    
    public void a(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (this.atZ != null) {
        this.atZ.onStateChanged(this.aua, paramInt1, paramInt2, paramBundle);
      }
    }
    
    public void a(SupportWalletFragment.OnStateChangedListener paramOnStateChangedListener)
    {
      this.atZ = paramOnStateChangedListener;
    }
  }
  
  private static class b
    implements LifecycleDelegate
  {
    private final or aub;
    
    private b(or paramor)
    {
      this.aub = paramor;
    }
    
    private int getState()
    {
      try
      {
        int i = this.aub.getState();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
    {
      try
      {
        this.aub.initialize(paramWalletFragmentInitParams);
        return;
      }
      catch (RemoteException paramWalletFragmentInitParams)
      {
        throw new RuntimeException(paramWalletFragmentInitParams);
      }
    }
    
    private void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      try
      {
        this.aub.onActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      }
      catch (RemoteException paramIntent)
      {
        throw new RuntimeException(paramIntent);
      }
    }
    
    private void setEnabled(boolean paramBoolean)
    {
      try
      {
        this.aub.setEnabled(paramBoolean);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void updateMaskedWallet(MaskedWallet paramMaskedWallet)
    {
      try
      {
        this.aub.updateMaskedWallet(paramMaskedWallet);
        return;
      }
      catch (RemoteException paramMaskedWallet)
      {
        throw new RuntimeException(paramMaskedWallet);
      }
    }
    
    private void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
    {
      try
      {
        this.aub.updateMaskedWalletRequest(paramMaskedWalletRequest);
        return;
      }
      catch (RemoteException paramMaskedWalletRequest)
      {
        throw new RuntimeException(paramMaskedWalletRequest);
      }
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.aub.onCreate(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeException(paramBundle);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      try
      {
        paramLayoutInflater = (View)e.f(this.aub.onCreateView(e.k(paramLayoutInflater), e.k(paramViewGroup), paramBundle));
        return paramLayoutInflater;
      }
      catch (RemoteException paramLayoutInflater)
      {
        throw new RuntimeException(paramLayoutInflater);
      }
    }
    
    public void onDestroy() {}
    
    public void onDestroyView() {}
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      paramBundle1 = (WalletFragmentOptions)paramBundle1.getParcelable("extraWalletFragmentOptions");
      try
      {
        this.aub.a(e.k(paramActivity), paramBundle1, paramBundle2);
        return;
      }
      catch (RemoteException paramActivity)
      {
        throw new RuntimeException(paramActivity);
      }
    }
    
    public void onLowMemory() {}
    
    public void onPause()
    {
      try
      {
        this.aub.onPause();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onResume()
    {
      try
      {
        this.aub.onResume();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onSaveInstanceState(Bundle paramBundle)
    {
      try
      {
        this.aub.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeException(paramBundle);
      }
    }
    
    public void onStart()
    {
      try
      {
        this.aub.onStart();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onStop()
    {
      try
      {
        this.aub.onStop();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
  }
  
  private class c
    extends a<SupportWalletFragment.b>
    implements View.OnClickListener
  {
    private c() {}
    
    protected void a(FrameLayout paramFrameLayout)
    {
      Button localButton = new Button(SupportWalletFragment.a(SupportWalletFragment.this).getActivity());
      localButton.setText(R.string.wallet_buy_button_place_holder);
      int k = -1;
      int m = -2;
      int j = m;
      int i = k;
      if (SupportWalletFragment.e(SupportWalletFragment.this) != null)
      {
        WalletFragmentStyle localWalletFragmentStyle = SupportWalletFragment.e(SupportWalletFragment.this).getFragmentStyle();
        j = m;
        i = k;
        if (localWalletFragmentStyle != null)
        {
          DisplayMetrics localDisplayMetrics = SupportWalletFragment.a(SupportWalletFragment.this).getResources().getDisplayMetrics();
          i = localWalletFragmentStyle.a("buyButtonWidth", localDisplayMetrics, -1);
          j = localWalletFragmentStyle.a("buyButtonHeight", localDisplayMetrics, -2);
        }
      }
      localButton.setLayoutParams(new ViewGroup.LayoutParams(i, j));
      localButton.setOnClickListener(this);
      paramFrameLayout.addView(localButton);
    }
    
    protected void a(f<SupportWalletFragment.b> paramf)
    {
      Object localObject = SupportWalletFragment.a(SupportWalletFragment.this).getActivity();
      if ((SupportWalletFragment.b(SupportWalletFragment.this) == null) && (SupportWalletFragment.c(SupportWalletFragment.this)) && (localObject != null)) {}
      try
      {
        localObject = oz.a((Activity)localObject, SupportWalletFragment.d(SupportWalletFragment.this), SupportWalletFragment.e(SupportWalletFragment.this), SupportWalletFragment.f(SupportWalletFragment.this));
        SupportWalletFragment.a(SupportWalletFragment.this, new SupportWalletFragment.b((or)localObject, null));
        SupportWalletFragment.a(SupportWalletFragment.this, null);
        paramf.a(SupportWalletFragment.b(SupportWalletFragment.this));
        if (SupportWalletFragment.g(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.b.a(SupportWalletFragment.b(SupportWalletFragment.this), SupportWalletFragment.g(SupportWalletFragment.this));
          SupportWalletFragment.a(SupportWalletFragment.this, null);
        }
        if (SupportWalletFragment.h(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.b.a(SupportWalletFragment.b(SupportWalletFragment.this), SupportWalletFragment.h(SupportWalletFragment.this));
          SupportWalletFragment.a(SupportWalletFragment.this, null);
        }
        if (SupportWalletFragment.i(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.b.a(SupportWalletFragment.b(SupportWalletFragment.this), SupportWalletFragment.i(SupportWalletFragment.this));
          SupportWalletFragment.a(SupportWalletFragment.this, null);
        }
        if (SupportWalletFragment.j(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.b.a(SupportWalletFragment.b(SupportWalletFragment.this), SupportWalletFragment.j(SupportWalletFragment.this).booleanValue());
          SupportWalletFragment.a(SupportWalletFragment.this, null);
        }
        return;
      }
      catch (GooglePlayServicesNotAvailableException paramf) {}
    }
    
    public void onClick(View paramView)
    {
      paramView = SupportWalletFragment.a(SupportWalletFragment.this).getActivity();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramView), paramView, -1);
    }
  }
}


/* Location:              /Users/michael/Downloads/dex2jar-2.0/GO_JEK.jar!/com/google/android/gms/wallet/fragment/SupportWalletFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */