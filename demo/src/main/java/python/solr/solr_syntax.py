#!/usr/bin/env python
# coding: utf-8

import pysolr
import unittest

'''
solr的查询语法说明：
1.query：通用查询字符串
'''


class SolrSyntaxTest(unittest.TestCase):
    python.solr = None

    def tearDown(self):
        self.python.solr = pysolr.Solr('http://10.10.17.117:8983/python.solr/zfy', timeout=10)

    def testQuery(self):
        pass


if __name__ == '__main__':
    unittest.main()
