package com.hayukleung.xgithub.contract;

import com.hayukleung.mvp.lce.LCEView;
import com.hayukleung.xgithub.model.Stub;
import com.hayukleung.xgithub.presenter.RXMVPPresenter;

/**
 * XGitHub
 * com.hayukleung.xgithub.contract
 * ContractMain.java
 *
 * by hayukleung
 * at 2017-04-06 11:30
 */

public interface ContractMain {

  public interface IViewMain extends LCEView<Stub, IPresenterMain> {

  }

  public abstract class IPresenterMain extends RXMVPPresenter<IViewMain> {

  }
}
