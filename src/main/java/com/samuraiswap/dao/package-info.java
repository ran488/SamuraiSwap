/**
 * DAO's (data accessor objects) - fancy way of saying "the classes that actually touch the underlying datasource, so nobody else has to". In theory, you could swap out data providers and the application as a whole should not have to care - just update this layer. Your business classes shouldn't know or care about Oracle, PostgreSQL, MySQL, MongoDB, etc.
 * @author Robb
 *
 */
package com.samuraiswap.dao;