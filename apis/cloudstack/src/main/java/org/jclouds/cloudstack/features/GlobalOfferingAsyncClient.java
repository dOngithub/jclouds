/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.cloudstack.features;

import com.google.common.util.concurrent.ListenableFuture;
import org.jclouds.cloudstack.domain.DiskOffering;
import org.jclouds.cloudstack.domain.NetworkOffering;
import org.jclouds.cloudstack.domain.ServiceOffering;
import org.jclouds.cloudstack.filters.QuerySigner;
import org.jclouds.cloudstack.options.CreateServiceOfferingOptions;
import org.jclouds.cloudstack.options.ListDiskOfferingsOptions;
import org.jclouds.cloudstack.options.ListNetworkOfferingsOptions;
import org.jclouds.cloudstack.options.ListServiceOfferingsOptions;
import org.jclouds.cloudstack.options.UpdateServiceOfferingOptions;
import org.jclouds.rest.annotations.ExceptionParser;
import org.jclouds.rest.annotations.OnlyElement;
import org.jclouds.rest.annotations.QueryParams;
import org.jclouds.rest.annotations.RequestFilters;
import org.jclouds.rest.annotations.SelectJson;
import org.jclouds.rest.functions.ReturnEmptySetOnNotFoundOr404;
import org.jclouds.rest.functions.ReturnNullOnNotFoundOr404;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Set;

/**
 * Provides asynchronous access to cloudstack via their REST API.
 * <p/>
 * 
 * @see GlobalOfferingClient
 * @see <a href="http://download.cloud.com/releases/2.2.0/api_2.2.12/TOC_Global_Admin.html" />
 * @author Andrei Savu
 */
@RequestFilters(QuerySigner.class)
@QueryParams(keys = "response", values = "json")
public interface GlobalOfferingAsyncClient extends OfferingAsyncClient {

   /**
    * @see GlobalOfferingClient#createServiceOffering
    */
   @GET
   @QueryParams(keys = "command", values = "createServiceOffering")
   @SelectJson("serviceoffering")
   @Consumes(MediaType.APPLICATION_JSON)
   @ExceptionParser(ReturnNullOnNotFoundOr404.class)
   ListenableFuture<ServiceOffering> createServiceOffering(@QueryParam("name") String name, @QueryParam("displaytext") String displayText,
         @QueryParam("cpunumber") int cpuNumber, @QueryParam("cpuspeed") int cpuSpeedInMHz, @QueryParam("memory") int memoryInMB, CreateServiceOfferingOptions... options);


   /**
    * @see GlobalOfferingClient#updateServiceOffering
    */
   @GET
   @QueryParams(keys = "command", values = "updateServiceOffering")
   @SelectJson("serviceoffering")
   @Consumes(MediaType.APPLICATION_JSON)
   @ExceptionParser(ReturnNullOnNotFoundOr404.class)
   ListenableFuture<ServiceOffering> updateServiceOffering(@QueryParam("id") long id, UpdateServiceOfferingOptions... options);

   /**
    * @see GlobalOfferingClient#deleteServiceOffering
    */
   @GET
   @QueryParams(keys = "command", values = "deleteServiceOffering")
   @Consumes(MediaType.APPLICATION_JSON)
   @ExceptionParser(ReturnNullOnNotFoundOr404.class)
   ListenableFuture<Void> deleteServiceOffering(@QueryParam("id") long id);

}