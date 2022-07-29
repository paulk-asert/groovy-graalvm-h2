/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import groovy.sql.Sql
import groovy.transform.CompileStatic

@CompileStatic
class H2Demo {
    static void main(args) {
        println "${System.getProperty('java.vm.name')}, ${System.getProperty('java.vm.version')}, ${System.getProperty('java.vm.vendor')}"
        Sql.withInstance('jdbc:h2:./data/test') { sql ->
            sql.execute 'DROP TABLE IF EXISTS customers'
            sql.execute 'CREATE TABLE customers(id INTEGER AUTO_INCREMENT, name VARCHAR)'
            for (cust in ['Lord Archimonde', 'Arthur', 'Gilbert', 'Grug']) {
                sql.executeInsert "INSERT INTO customers(name) VALUES $cust"
            }
            println sql.rows('SELECT * FROM customers').join('\n')
        }
    }
}
