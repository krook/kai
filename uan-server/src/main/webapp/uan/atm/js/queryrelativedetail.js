/*
 * Copyright 2018 Liu Jiajie
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 *  queryrelativedetail.js
 *  功能    查询-授权人资产详情视图
 *  作者    xxx
 *  日期    2018-09-xx
 *  当前路由 /queryrelativedetail
 *  前一路由 /queryrelativeasset
 *  后一路由 /uanindex
 *  输出变量 window.app.withdrawresultV
 * 
 *
 */
;(function(factory) {
    if (typeof define === 'function' && define.amd) {
      // AMD. Register as anonymous module.
      define(['jquery'], function(jQuery) {
        return factory(jQuery, window, document);
      });
    } else if (typeof module === 'object' && module.exports) {
      // Node. Does not work with strict CommonJS, but
      // only CommonJS-like enviroments that support module.exports,
      // like Node.
      module.exports = factory(require('jquery'), window, document);
    } else {
      // Browser globals.
      factory(jQuery, window, document);
    }
  }(function($, window, document, undefined) {
    'use strict';
  
    // 获取全局变量，若为空则对其初始化
    var kendo = window.kendo,
      app = window.app,
      layout = app.layout,
      router = app.router,
      layoutSelector = app.layoutSelector;
  
      // 构造视图DOM模板
      var queryRelativeDetailDomTemplate = '<a class="atm-btn btn-left btn-row-4" data-bind="click: prevPage">\
        <span class="zh-CN">查看其他账户</span>\
        <span class="en-US">View Other Accounts</span>\
      </a>\
      <a class="atm-btn btn-right btn-row-4" data-bind="click: returnToIndex">返回/return</a>\
      <div class="container-fluid">\
\
        <div class="title">\
          <div class="zh-CN">请查看授权人账户信息</div>\
          <div class="en-US">Pleace check the information of the contracted account.</div>\
        </div>\
\
        <div class="amt-checkinfo-bar form-horizontal">\
          <div class="form-group">\
            <div class="col-xs-5 info-key">\
              <div class="zh-CN">姓&nbsp;&nbsp;&nbsp;名</div><div class="en-US">Full Name</div>\
            </div>\
            <div class="col-xs-7 info-value">\
              <div class="info-value" data-bind="text:customerInformation.name"></div>\
            </div>\
          </div>\
\
          <div class="form-group">\
            <div class="col-xs-5 info-key">\
              <div class="zh-CN">账&nbsp;&nbsp;&nbsp;号</div><div class="en-US">Account No.</div>\
            </div>\
            <div class="col-xs-7 info-value">\
              <div class="info-value" data-bind="text:code"></div>\
            </div>\
          </div>\
  \
          <div class="form-group">\
            <div class="col-xs-5 info-key">\
              <div class="zh-CN">电&nbsp;&nbsp;&nbsp;话</div><div class="en-US">Phone</div>\
            </div>\
            <div class="col-xs-7 info-value"><div class="info-value" data-bind="text:customerInformation.phone"></div></div>\
          </div>\
\
          <div class="form-group">\
            <div class="col-xs-5 info-key">\
              <div class="zh-CN">余&nbsp;&nbsp;&nbsp;额</div><div class="en-US">Balance</div>\
            </div>\
            <div class="col-xs-7 info-value">\
              <div class="info-value">\
              CNY <span data-bind="text:amt"></span>.00\
              </div>\
            </div>\
          </div>\
\
          <div class="form-group">\
            <div class="col-xs-5 info-key">\
              <div class="zh-CN">开户行</div><div class="en-US">Bank Of Deposit</div>\
            </div>\
            <div class="col-xs-7 info-value">\
              <div class="info-value" data-bind="text:bankOfDeposit"></div>\
            </div>\
          </div>\
\
      </div>';
  
    // 使用template构造DOM字符串，传入从上一视图读取的变量
    var queryRelativeDetailDomString = kendo.template(queryRelativeDetailDomTemplate)({});
  
    // queryRelativeDetail视图view modal
    var queryRelativeDetailVM = kendo.observable({
      amt: '',
      bankOfDeposit: '',
      code: '',
      customerInformation: {
        id: '',
        idCard: '',
        name: '',
        phone: '',
        state: '',
        type: ''
      },
      id: '',
      idCard: '',
      state: '',
      // init: function () {
      // },
      show: function () {
        var data = app.queryRelativeAssetV.model.get('currentRowData');
        // 判断assetV授权人资产表格是否已选中行，否则跳转至 /queryrelativeasset
        if(!data) {
          // 跳转路由至 /queryrelativeasset
          app.redirectTo('/queryrelativeasset');
        }

        this.set('amt', data.amt);
        this.set('bankOfDeposit', data.bankOfDeposit);
        this.set('code', data.code);
        this.set('customerInformation', data.customerInformation);
        this.set('id', data.id);
        this.set('idCard', data.idCard);
        this.set('state', data.state);
      },
      hide: function () {
        this.set('amt', '');
        this.set('bankOfDeposit', '');
        this.set('code', '');
        this.set('customerInformation', {});
        this.set('id', '');
        this.set('idCard', '');
        this.set('state', '');
      },
      prevPage: function () {
        router.navigate('/queryrelativeasset');
      },
      returnToIndex: function () {
        router.navigate('/uanindex');
      },
    });
  
    // queryRelativeDetail视图view，从字符串变量queryRelativeDetailDomString中加载DOM结构，绑定ViewModel
    var queryRelativeDetailV = new kendo.View(queryRelativeDetailDomString, {
      model: queryRelativeDetailVM, 
      // init: queryRelativeDetailVM.init.bind(queryRelativeDetailVM),
      show: queryRelativeDetailVM.show.bind(queryRelativeDetailVM),
      hide: queryRelativeDetailVM.hide.bind(queryRelativeDetailVM),
      prevPage: queryRelativeDetailVM.prevPage.bind(queryRelativeDetailVM),
      returnToIndex: queryRelativeDetailVM.returnToIndex.bind(queryRelativeDetailVM)
    });
  
    // queryRelativeDetail视图路由，渲染指定view
    router.route('/queryrelativedetail', function () {
      layout.showIn(layoutSelector,queryRelativeDetailV);
    });
  
      // 输出至全局变量app
      window.app = $.extend(true, app, {
        'queryRelativeDetailV': queryRelativeDetailV
      });
  
  }));
  