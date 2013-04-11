/** 
 
Copyright 2013 Intel Corporation, All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
*/ 

package com.intel.cosbench.driver.handler;

import javax.servlet.http.*;

import com.intel.cosbench.model.DriverInfo;
import com.intel.cosbench.protocol.*;
import com.intel.cosbench.service.DriverService;

public class PingHandler extends AbstractCommandHandler {

    private DriverService driver;

    public void setDriver(DriverService driver) {
        this.driver = driver;
    }

    @Override
    protected Response process(HttpServletRequest req, HttpServletResponse res) {
        PingResponse response = new PingResponse();
        DriverInfo info = driver.getDriverInfo();
        response.setName(info.getName());
        response.setAddress(info.getUrl());
        return response;
    }

}
