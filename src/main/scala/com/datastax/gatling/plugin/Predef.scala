/*
 * Copyright (c) 2018 Datastax Inc.
 *
 * This software can be used solely with DataStax products. Please consult the file LICENSE.md.
 */

package com.datastax.gatling.plugin

import com.datastax.gatling.plugin.checks.DseCheckSupport
import com.datastax.gatling.plugin.request._
import io.gatling.core.action.builder.ActionBuilder

import scala.language.implicitConversions


trait DsePredefBase extends DseCheckSupport {

  val dseProtocolBuilder = DseProtocolBuilder

  /**
    * Present for backwards compatibility
    *
    * @deprecated use dseProtocolBuilder instead, will be removed in future versions
    */
  val graph = dseProtocolBuilder

  /**
    * Present for backwards compatibility
    *
    * @deprecated use dseProtocolBuilder instead, will be removed in future versions
    */
  val cql = dseProtocolBuilder

  def cql(tag: String) = CqlRequestBuilder(tag)

  def graph(tag: String) = GraphRequestBuilder(tag)

  implicit def protocolBuilder2DseProtocol(builder: DseProtocolBuilder): DseProtocol = builder.build

  implicit def cqlRequestAttributes2ActionBuilder(builder: DseCqlRequestAttributes): ActionBuilder = builder.build()

  implicit def graphRequestAttributes2ActionBuilder(builder: DseGraphRequestAttributes): ActionBuilder = builder.build()
}

/**
  * DsePredef which should be used for both
  */
object DsePredef extends DsePredefBase {}

/**
  * Present for backwards compatibility
  *
  * @deprecated use DsePredef instead, will be removed in future versions
  */
object CqlPredef extends DsePredefBase {}

/**
  * Present for backwards compatibility
  *
  * @deprecated use DsePredef instead, will be removed in future versions
  */
object GraphPredef extends DsePredefBase {}


