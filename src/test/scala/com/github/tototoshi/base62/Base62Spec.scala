/*
* Copyright 2013 Toshiyuki Takahashi
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.github.tototoshi.base62

import org.scalatest._
import org.scalatest.matchers._
import scala.language.reflectiveCalls

class Base62Spec extends FunSpec with ShouldMatchers with OptionValues {

  def fixture = new {
    val base62 = new Base62()
  }

  describe("Base62") {

    it("should encode number to base62 string") {
      fixture.base62.encode(123456789L) should be("8M0kX")
    }

    it("should decode base62 string to number") {
      fixture.base62.decode("8M0kX") should be(123456789L)
    }

  }

}
