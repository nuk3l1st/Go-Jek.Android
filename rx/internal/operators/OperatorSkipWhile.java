package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

public final class OperatorSkipWhile<T>
  implements Observable.Operator<T, T>
{
  private final Func2<? super T, Integer, Boolean> predicate;
  
  public OperatorSkipWhile(Func2<? super T, Integer, Boolean> paramFunc2)
  {
    this.predicate = paramFunc2;
  }
  
  public static <T> Func2<T, Integer, Boolean> toPredicate2(Func1<? super T, Boolean> paramFunc1)
  {
    return new OperatorSkipWhile.2(paramFunc1);
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorSkipWhile.1(this, paramSubscriber, paramSubscriber);
  }
}


/* Location:              /Users/michael/Downloads/dex2jar-2.0/GO_JEK.jar!/rx/internal/operators/OperatorSkipWhile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */