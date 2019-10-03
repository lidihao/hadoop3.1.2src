/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.yarn.server.resourcemanager.rmapp.attempt;

public enum RMAppAttemptEventType {
  // Source: RMApp
  START,
  KILL,
  FAIL,

  // Source: AMLauncher
  LAUNCHED,
  LAUNCH_FAILED,

  // Source: AMLivelinessMonitor
  EXPIRE,
  
  // Source: ApplicationMasterService
  REGISTERED,
  // ApplicaitionMaster需周期性地调用RPC函数ApplicationMasterProtocol#allocate
  // 向ResourceManager汇报自己的进度，申请资源和获取已经分配的资源，每次调用会触发一个
  // STATUS_UPDATE事件,从而引发RMAppAttemptImpl保存它的最新执行进度
  STATUS_UPDATE,
  UNREGISTERED,

  // Source: Containers
  CONTAINER_ALLOCATED,
  CONTAINER_FINISHED,
  
  // Source: RMStateStore
  ATTEMPT_NEW_SAVED,
  ATTEMPT_UPDATE_SAVED,

  // Source: Scheduler
  ATTEMPT_ADDED,
  
  // Source: RMAttemptImpl.recover
  RECOVER

}
