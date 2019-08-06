import React, { Component } from 'react'

export default class Prova extends Component {
  render() {
    return (
      <div>
        <div className="content-wrapper">
          {/* Content Header (Page header) */}
          <section className="content-header">
            <h1>
              Dashboard
        <small>Control panel</small>
            </h1>
            <ol className="breadcrumb">
              <li><a href="#"><i className="fa fa-dashboard" /> Home</a></li>
              <li className="active">Dashboard</li>
            </ol>
          </section>
          {/* Main content */}
          <section className="content">
            {/* Small boxes (Stat box) */}
            <div className="row">
              <div className="col-lg-3 col-xs-6">
                {/* small box */}
                <div className="small-box bg-aqua">
                  <div className="inner">
                    <h3>150</h3>
                    <p>New Orders</p>
                  </div>
                  <div className="icon">
                    <i className="ion ion-bag" />
                  </div>
                  <a href="#" className="small-box-footer">More info <i className="fa fa-arrow-circle-right" /></a>
                </div>
              </div>
              {/* ./col */}
              <div className="col-lg-3 col-xs-6">
                {/* small box */}
                <div className="small-box bg-green">
                  <div className="inner">
                    <h3>53<sup style={{ fontSize: 20 }}>%</sup></h3>
                    <p>Bounce Rate</p>
                  </div>
                  <div className="icon">
                    <i className="ion ion-stats-bars" />
                  </div>
                  <a href="#" className="small-box-footer">More info <i className="fa fa-arrow-circle-right" /></a>
                </div>
              </div>
              {/* ./col */}
              <div className="col-lg-3 col-xs-6">
                {/* small box */}
                <div className="small-box bg-yellow">
                  <div className="inner">
                    <h3>44</h3>
                    <p>User Registrations</p>
                  </div>
                  <div className="icon">
                    <i className="ion ion-person-add" />
                  </div>
                  <a href="#" className="small-box-footer">More info <i className="fa fa-arrow-circle-right" /></a>
                </div>
              </div>
              {/* ./col */}
              <div className="col-lg-3 col-xs-6">
                {/* small box */}
                <div className="small-box bg-red">
                  <div className="inner">
                    <h3>65</h3>
                    <p>Unique Visitors</p>
                  </div>
                  <div className="icon">
                    <i className="ion ion-pie-graph" />
                  </div>
                  <a href="#" className="small-box-footer">More info <i className="fa fa-arrow-circle-right" /></a>
                </div>
              </div>






            </div>

            <div className="row">
              {/* Left col */}
              <section className="col-lg-7 connectedSortable">

                {/* TO DO List */}
                <div className="box box-primary">
                  <div className="box-header">
                    <i className="ion ion-clipboard" />
                    <h3 className="box-title">To Do List</h3>
                    <div className="box-tools pull-right">
                      <ul className="pagination pagination-sm inline">
                        <li><a href="#">«</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">»</a></li>
                      </ul>
                    </div>
                  </div>
                  {/* /.box-header */}
                  <div className="box-body">
                    {/* See dist/js/pages/dashboard.js to activate the todoList plugin */}
                    <ul className="todo-list">
                      <li>
                        {/* drag handle */}
                        <span className="handle">
                          <i className="fa fa-ellipsis-v" />
                          <i className="fa fa-ellipsis-v" />
                        </span>
                        {/* checkbox */}
                        <input type="checkbox" defaultValue />
                        {/* todo text */}
                        <span className="text">Design a nice theme</span>
                        {/* Emphasis label */}
                        <small className="label label-danger"><i className="fa fa-clock-o" /> 2 mins</small>
                        {/* General tools such as edit or delete*/}
                        <div className="tools">
                          <i className="fa fa-edit" />
                          <i className="fa fa-trash-o" />
                        </div>
                      </li>
                      <li>
                        <span className="handle">
                          <i className="fa fa-ellipsis-v" />
                          <i className="fa fa-ellipsis-v" />
                        </span>
                        <input type="checkbox" defaultValue />
                        <span className="text">Make the theme responsive</span>
                        <small className="label label-info"><i className="fa fa-clock-o" /> 4 hours</small>
                        <div className="tools">
                          <i className="fa fa-edit" />
                          <i className="fa fa-trash-o" />
                        </div>
                      </li>
                      <li>
                        <span className="handle">
                          <i className="fa fa-ellipsis-v" />
                          <i className="fa fa-ellipsis-v" />
                        </span>
                        <input type="checkbox" defaultValue />
                        <span className="text">Let theme shine like a star</span>
                        <small className="label label-warning"><i className="fa fa-clock-o" /> 1 day</small>
                        <div className="tools">
                          <i className="fa fa-edit" />
                          <i className="fa fa-trash-o" />
                        </div>
                      </li>
                      <li>
                        <span className="handle">
                          <i className="fa fa-ellipsis-v" />
                          <i className="fa fa-ellipsis-v" />
                        </span>
                        <input type="checkbox" defaultValue />
                        <span className="text">Let theme shine like a star</span>
                        <small className="label label-success"><i className="fa fa-clock-o" /> 3 days</small>
                        <div className="tools">
                          <i className="fa fa-edit" />
                          <i className="fa fa-trash-o" />
                        </div>
                      </li>
                      <li>
                        <span className="handle">
                          <i className="fa fa-ellipsis-v" />
                          <i className="fa fa-ellipsis-v" />
                        </span>
                        <input type="checkbox" defaultValue />
                        <span className="text">Check your messages and notifications</span>
                        <small className="label label-primary"><i className="fa fa-clock-o" /> 1 week</small>
                        <div className="tools">
                          <i className="fa fa-edit" />
                          <i className="fa fa-trash-o" />
                        </div>
                      </li>
                      <li>
                        <span className="handle">
                          <i className="fa fa-ellipsis-v" />
                          <i className="fa fa-ellipsis-v" />
                        </span>
                        <input type="checkbox" defaultValue />
                        <span className="text">Let theme shine like a star</span>
                        <small className="label label-default"><i className="fa fa-clock-o" /> 1 month</small>
                        <div className="tools">
                          <i className="fa fa-edit" />
                          <i className="fa fa-trash-o" />
                        </div>
                      </li>
                    </ul>
                  </div>
                  {/* /.box-body */}
                  <div className="box-footer clearfix no-border">
                    <button type="button" className="btn btn-default pull-right"><i className="fa fa-plus" /> Add item</button>
                  </div>
                </div>
                {/* /.box */}

              </section>
              {/* /.Left col */}
              {/* right col (We are only adding the ID to make the widgets sortable)*/}
              <section className="col-lg-5 connectedSortable">
                {/* Map box */}
                <div className="box box-solid bg-light-blue-gradient">




                </div>










                {/* Calendar */}
                <div className="box box-solid bg-green-gradient">
                  <div className="box-header">
                    <i className="fa fa-calendar" />
                    <h3 className="box-title">Calendar</h3>
                    {/* tools box */}
                    <div className="pull-right box-tools">
                      {/* button with a dropdown */}
                      <div className="btn-group">
                        <button type="button" className="btn btn-success btn-sm dropdown-toggle" data-toggle="dropdown">
                          <i className="fa fa-bars" /></button>
                        <ul className="dropdown-menu pull-right" role="menu">
                          <li><a href="#">Add new event</a></li>
                          <li><a href="#">Clear events</a></li>
                          <li className="divider" />
                          <li><a href="#">View calendar</a></li>
                        </ul>
                      </div>
                      <button type="button" className="btn btn-success btn-sm" data-widget="collapse"><i className="fa fa-minus" />
                      </button>
                      <button type="button" className="btn btn-success btn-sm" data-widget="remove"><i className="fa fa-times" />
                      </button>
                    </div>
                    {/* /. tools */}
                  </div>
                  {/* /.box-header */}
                  <div className="box-body no-padding">
                    {/*The calendar */}
                    <div id="calendar" style={{ width: '100%' }} />
                  </div>
                  {/* /.box-body */}
                  <div className="box-footer text-black">
                    <div className="row">
                      <div className="col-sm-6">
                        {/* Progress bars */}
                        <div className="clearfix">
                          <span className="pull-left">Task #1</span>
                          <small className="pull-right">90%</small>
                        </div>
                        <div className="progress xs">
                          <div className="progress-bar progress-bar-green" style={{ width: '90%' }} />
                        </div>
                        <div className="clearfix">
                          <span className="pull-left">Task #2</span>
                          <small className="pull-right">70%</small>
                        </div>
                        <div className="progress xs">
                          <div className="progress-bar progress-bar-green" style={{ width: '70%' }} />
                        </div>
                      </div>
                      {/* /.col */}
                      <div className="col-sm-6">
                        <div className="clearfix">
                          <span className="pull-left">Task #3</span>
                          <small className="pull-right">60%</small>
                        </div>
                        <div className="progress xs">
                          <div className="progress-bar progress-bar-green" style={{ width: '60%' }} />
                        </div>
                        <div className="clearfix">
                          <span className="pull-left">Task #4</span>
                          <small className="pull-right">40%</small>
                        </div>
                        <div className="progress xs">
                          <div className="progress-bar progress-bar-green" style={{ width: '40%' }} />
                        </div>
                      </div>
                      {/* /.col */}
                    </div>
                    {/* /.row */}
                  </div>
                </div>
                {/* /.box */}
              </section>
              {/* right col */}
            </div>
            {/* /.row (main row) */}
          </section>
          {/* /.content */}
        </div>
        {/* /.content-wrapper */}
      </div>

    )
  }
}
