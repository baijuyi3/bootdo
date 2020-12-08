$(function () {

    var prefix = "/futures";
    var futures;
    var date = new Array();
    var price = new Array();
    var priceList = new Array();

    $.ajax({
        type: 'POST',
        url: prefix + '/history',
        beforeSend: function (request) {      //使用beforeSend
            request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        },

        dataType: 'json',
        async: false,
        data: {"trancode": "RM%01"},
        success: function (data) {
            futures = data;
            console.log(data)
            $.each(futures, function (n, value) {
                date.push(value.time.substring(0, 10));
                price.push(value.opening);
                price.push(value.highest);
                price.push(value.lowest);
                price.push(value.closing);
                priceList.push(price);
                price = [];
            });
            console.log(date);
            console.log(priceList);
        }

    });


    var kChart = echarts.init(document.getElementById("echarts-k-chart"));
    var koption = {
        title: {
            text: '2013年上半年上证指数'
        },
        tooltip: {
            trigger: 'axis',
            formatter: function (params) {
                var res = params[0].seriesName + ' ' + params[0].name;
                res += '<br/>  开盘 : ' + params[0].value[0] + '  最高 : ' + params[0].value[3];
                res += '<br/>  收盘 : ' + params[0].value[1] + '  最低 : ' + params[0].value[2];
                return res;
            }
        },
        legend: {
            data: ['上证指数']
        },
        grid: {
            x: 40,
            x2: 2
        },
        dataZoom: {
            show: true,
            realtime: true,
            start: 50,
            end: 100
        },
        xAxis: [
            {
                type: 'category',
                boundaryGap: true,
                axisTick: {onGap: false},
                splitLine: {show: false},
                data: date
            }
        ],
        yAxis: [
            {
                type: 'value',
                scale: true,
                boundaryGap: [0.01, 0.01]
            }
        ],
        series: [
            {
                name: '上证指数',
                type: 'k',
                data: priceList,
                height: 480
            }
        ]
    };
    kChart.setOption(koption);
    $(window).resize(kChart.resize);

    // var pieChart = echarts.init(document.getElementById("echarts-pie-chart"));
    // var pieoption = {
    //     title: {
    //         text: '某站点用户访问来源',
    //         subtext: '纯属虚构',
    //         x: 'center'
    //     },
    //     tooltip: {
    //         trigger: 'item',
    //         formatter: "{a} <br/>{b} : {c} ({d}%)"
    //     },
    //     legend: {
    //         orient: 'vertical',
    //         x: 'left',
    //         data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
    //     },
    //     calculable: true,
    //     series: [
    //         {
    //             name: '访问来源',
    //             type: 'pie',
    //             radius: '55%',
    //             center: ['50%', '60%'],
    //             data: [
    //                 {value: 335, name: '直接访问'},
    //                 {value: 310, name: '邮件营销'},
    //                 {value: 234, name: '联盟广告'},
    //                 {value: 135, name: '视频广告'},
    //                 {value: 1548, name: '搜索引擎'}
    //             ]
    //         }
    //     ]
    // };
    // pieChart.setOption(pieoption);
    // $(window).resize(pieChart.resize);
    //
    // var radarChart = echarts.init(document.getElementById("echarts-radar-chart"));
    // var radaroption = {
    //     title: {
    //         text: '预算 vs 开销',
    //         subtext: '纯属虚构'
    //     },
    //     tooltip: {
    //         trigger: 'axis'
    //     },
    //     legend: {
    //         orient: 'vertical',
    //         x: 'right',
    //         y: 'bottom',
    //         data: ['预算分配', '实际开销']
    //     },
    //     polar: [
    //         {
    //             indicator: [
    //                 {text: '销售', max: 6000},
    //                 {text: '管理', max: 16000},
    //                 {text: '信息技术', max: 30000},
    //                 {text: '客服', max: 38000},
    //                 {text: '研发', max: 52000},
    //                 {text: '市场', max: 25000}
    //             ]
    //         }
    //     ],
    //     calculable: true,
    //     series: [
    //         {
    //             name: '预算 vs 开销',
    //             type: 'radar',
    //             data: [
    //                 {
    //                     value: [4300, 10000, 28000, 35000, 50000, 19000],
    //                     name: '预算分配'
    //                 },
    //                 {
    //                     value: [5000, 14000, 28000, 31000, 42000, 21000],
    //                     name: '实际开销'
    //                 }
    //             ]
    //         }
    //     ]
    // };
    //
    // radarChart.setOption(radaroption);
    // $(window).resize(radarChart.resize);
    //
    // var mapChart = echarts.init(document.getElementById("echarts-map-chart"));
    // var mapoption = {
    //     title: {
    //         text: 'iphone销量',
    //         subtext: '纯属虚构',
    //         x: 'center'
    //     },
    //     tooltip: {
    //         trigger: 'item'
    //     },
    //     legend: {
    //         orient: 'vertical',
    //         x: 'left',
    //         data: ['iphone3', 'iphone4', 'iphone5']
    //     },
    //     dataRange: {
    //         min: 0,
    //         max: 2500,
    //         x: 'left',
    //         y: 'bottom',
    //         text: ['高', '低'],           // 文本，默认为数值文本
    //         calculable: true
    //     },
    //     toolbox: {
    //         show: true,
    //         orient: 'vertical',
    //         x: 'right',
    //         y: 'center',
    //         feature: {
    //             mark: {show: true},
    //             dataView: {show: true, readOnly: false},
    //             restore: {show: true},
    //             saveAsImage: {show: true}
    //         }
    //     },
    //     roamController: {
    //         show: true,
    //         x: 'right',
    //         mapTypeControl: {
    //             'china': true
    //         }
    //     },
    //     series: [
    //         {
    //             name: 'iphone3',
    //             type: 'map',
    //             mapType: 'china',
    //             roam: false,
    //             itemStyle: {
    //                 normal: {label: {show: true}},
    //                 emphasis: {label: {show: true}}
    //             },
    //             data: [
    //                 {name: '北京', value: Math.round(Math.random() * 1000)},
    //                 {name: '天津', value: Math.round(Math.random() * 1000)},
    //                 {name: '上海', value: Math.round(Math.random() * 1000)},
    //                 {name: '重庆', value: Math.round(Math.random() * 1000)},
    //                 {name: '河北', value: Math.round(Math.random() * 1000)},
    //                 {name: '河南', value: Math.round(Math.random() * 1000)},
    //                 {name: '云南', value: Math.round(Math.random() * 1000)},
    //                 {name: '辽宁', value: Math.round(Math.random() * 1000)},
    //                 {name: '黑龙江', value: Math.round(Math.random() * 1000)},
    //                 {name: '湖南', value: Math.round(Math.random() * 1000)},
    //                 {name: '安徽', value: Math.round(Math.random() * 1000)},
    //                 {name: '山东', value: Math.round(Math.random() * 1000)},
    //                 {name: '新疆', value: Math.round(Math.random() * 1000)},
    //                 {name: '江苏', value: Math.round(Math.random() * 1000)},
    //                 {name: '浙江', value: Math.round(Math.random() * 1000)},
    //                 {name: '江西', value: Math.round(Math.random() * 1000)},
    //                 {name: '湖北', value: Math.round(Math.random() * 1000)},
    //                 {name: '广西', value: Math.round(Math.random() * 1000)},
    //                 {name: '甘肃', value: Math.round(Math.random() * 1000)},
    //                 {name: '山西', value: Math.round(Math.random() * 1000)},
    //                 {name: '内蒙古', value: Math.round(Math.random() * 1000)},
    //                 {name: '陕西', value: Math.round(Math.random() * 1000)},
    //                 {name: '吉林', value: Math.round(Math.random() * 1000)},
    //                 {name: '福建', value: Math.round(Math.random() * 1000)},
    //                 {name: '贵州', value: Math.round(Math.random() * 1000)},
    //                 {name: '广东', value: Math.round(Math.random() * 1000)},
    //                 {name: '青海', value: Math.round(Math.random() * 1000)},
    //                 {name: '西藏', value: Math.round(Math.random() * 1000)},
    //                 {name: '四川', value: Math.round(Math.random() * 1000)},
    //                 {name: '宁夏', value: Math.round(Math.random() * 1000)},
    //                 {name: '海南', value: Math.round(Math.random() * 1000)},
    //                 {name: '台湾', value: Math.round(Math.random() * 1000)},
    //                 {name: '香港', value: Math.round(Math.random() * 1000)},
    //                 {name: '澳门', value: Math.round(Math.random() * 1000)}
    //             ]
    //         },
    //         {
    //             name: 'iphone4',
    //             type: 'map',
    //             mapType: 'china',
    //             itemStyle: {
    //                 normal: {label: {show: true}},
    //                 emphasis: {label: {show: true}}
    //             },
    //             data: [
    //                 {name: '北京', value: Math.round(Math.random() * 1000)},
    //                 {name: '天津', value: Math.round(Math.random() * 1000)},
    //                 {name: '上海', value: Math.round(Math.random() * 1000)},
    //                 {name: '重庆', value: Math.round(Math.random() * 1000)},
    //                 {name: '河北', value: Math.round(Math.random() * 1000)},
    //                 {name: '安徽', value: Math.round(Math.random() * 1000)},
    //                 {name: '新疆', value: Math.round(Math.random() * 1000)},
    //                 {name: '浙江', value: Math.round(Math.random() * 1000)},
    //                 {name: '江西', value: Math.round(Math.random() * 1000)},
    //                 {name: '山西', value: Math.round(Math.random() * 1000)},
    //                 {name: '内蒙古', value: Math.round(Math.random() * 1000)},
    //                 {name: '吉林', value: Math.round(Math.random() * 1000)},
    //                 {name: '福建', value: Math.round(Math.random() * 1000)},
    //                 {name: '广东', value: Math.round(Math.random() * 1000)},
    //                 {name: '西藏', value: Math.round(Math.random() * 1000)},
    //                 {name: '四川', value: Math.round(Math.random() * 1000)},
    //                 {name: '宁夏', value: Math.round(Math.random() * 1000)},
    //                 {name: '香港', value: Math.round(Math.random() * 1000)},
    //                 {name: '澳门', value: Math.round(Math.random() * 1000)}
    //             ]
    //         },
    //         {
    //             name: 'iphone5',
    //             type: 'map',
    //             mapType: 'china',
    //             itemStyle: {
    //                 normal: {label: {show: true}},
    //                 emphasis: {label: {show: true}}
    //             },
    //             data: [
    //                 {name: '北京', value: Math.round(Math.random() * 1000)},
    //                 {name: '天津', value: Math.round(Math.random() * 1000)},
    //                 {name: '上海', value: Math.round(Math.random() * 1000)},
    //                 {name: '广东', value: Math.round(Math.random() * 1000)},
    //                 {name: '台湾', value: Math.round(Math.random() * 1000)},
    //                 {name: '香港', value: Math.round(Math.random() * 1000)},
    //                 {name: '澳门', value: Math.round(Math.random() * 1000)}
    //             ]
    //         }
    //     ]
    // };
    // mapChart.setOption(mapoption);
    // $(window).resize(mapChart.resize);
    //
    // var chordChart = echarts.init(document.getElementById("echarts-chord-chart"));
    // var chordoption = {
    //     title: {
    //         text: '测试数据',
    //         subtext: 'From d3.js',
    //         x: 'right',
    //         y: 'bottom'
    //     },
    //     tooltip: {
    //         trigger: 'item',
    //         formatter: function (params) {
    //             if (params.indicator2) { // is edge
    //                 return params.value.weight;
    //             } else {// is node
    //                 return params.name
    //             }
    //         }
    //     },
    //     toolbox: {
    //         show: true,
    //         feature: {
    //             restore: {show: true},
    //             magicType: {show: true, type: ['force', 'chord']},
    //             saveAsImage: {show: true}
    //         }
    //     },
    //     legend: {
    //         x: 'left',
    //         data: ['group1', 'group2', 'group3', 'group4']
    //     },
    //     series: [
    //         {
    //             type: 'chord',
    //             sort: 'ascending',
    //             sortSub: 'descending',
    //             showScale: true,
    //             showScaleText: true,
    //             data: [
    //                 {name: 'group1'},
    //                 {name: 'group2'},
    //                 {name: 'group3'},
    //                 {name: 'group4'}
    //             ],
    //             itemStyle: {
    //                 normal: {
    //                     label: {
    //                         show: false
    //                     }
    //                 }
    //             },
    //             matrix: [
    //                 [11975, 5871, 8916, 2868],
    //                 [1951, 10048, 2060, 6171],
    //                 [8010, 16145, 8090, 8045],
    //                 [1013, 990, 940, 6907]
    //             ]
    //         }
    //     ]
    // };
    //
    // chordChart.setOption(chordoption);
    // $(window).resize(chordChart.resize);
    //
    // var forceChart = echarts.init(document.getElementById("echarts-force-chart"));
    // var forceoption = {
    //     title: {
    //         text: '人物关系：乔布斯',
    //         subtext: '数据来自人立方',
    //         x: 'right',
    //         y: 'bottom'
    //     },
    //     tooltip: {
    //         trigger: 'item',
    //         formatter: '{a} : {b}'
    //     },
    //     toolbox: {
    //         show: true,
    //         feature: {
    //             restore: {show: true},
    //             magicType: {show: true, type: ['force', 'chord']},
    //             saveAsImage: {show: true}
    //         }
    //     },
    //     legend: {
    //         x: 'left',
    //         data: ['家人', '朋友']
    //     },
    //     series: [
    //         {
    //             type: 'force',
    //             name: "人物关系",
    //             ribbonType: false,
    //             categories: [
    //                 {
    //                     name: '人物'
    //                 },
    //                 {
    //                     name: '家人'
    //                 },
    //                 {
    //                     name: '朋友'
    //                 }
    //             ],
    //             itemStyle: {
    //                 normal: {
    //                     label: {
    //                         show: true,
    //                         textStyle: {
    //                             color: '#333'
    //                         }
    //                     },
    //                     nodeStyle: {
    //                         brushType: 'both',
    //                         borderColor: 'rgba(255,215,0,0.4)',
    //                         borderWidth: 1
    //                     },
    //                     linkStyle: {
    //                         type: 'curve'
    //                     }
    //                 },
    //                 emphasis: {
    //                     label: {
    //                         show: false
    //                         // textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
    //                     },
    //                     nodeStyle: {
    //                         //r: 30
    //                     },
    //                     linkStyle: {}
    //                 }
    //             },
    //             useWorker: false,
    //             minRadius: 15,
    //             maxRadius: 25,
    //             gravity: 1.1,
    //             scaling: 1.1,
    //             roam: 'move',
    //             nodes: [
    //                 {category: 0, name: '乔布斯', value: 10},
    //                 {category: 1, name: '丽萨-乔布斯', value: 2},
    //                 {category: 1, name: '保罗-乔布斯', value: 3},
    //                 {category: 1, name: '克拉拉-乔布斯', value: 3},
    //                 {category: 1, name: '劳伦-鲍威尔', value: 7},
    //                 {category: 2, name: '史蒂夫-沃兹尼艾克', value: 5},
    //                 {category: 2, name: '奥巴马', value: 8},
    //                 {category: 2, name: '比尔-盖茨', value: 9},
    //                 {category: 2, name: '乔纳森-艾夫', value: 4},
    //                 {category: 2, name: '蒂姆-库克', value: 4},
    //                 {category: 2, name: '龙-韦恩', value: 1},
    //             ],
    //             links: [
    //                 {source: '丽萨-乔布斯', target: '乔布斯', weight: 1, name: '女儿'},
    //                 {source: '保罗-乔布斯', target: '乔布斯', weight: 2, name: '父亲'},
    //                 {source: '克拉拉-乔布斯', target: '乔布斯', weight: 1, name: '母亲'},
    //                 {source: '劳伦-鲍威尔', target: '乔布斯', weight: 2},
    //                 {source: '史蒂夫-沃兹尼艾克', target: '乔布斯', weight: 3, name: '合伙人'},
    //                 {source: '奥巴马', target: '乔布斯', weight: 1},
    //                 {source: '比尔-盖茨', target: '乔布斯', weight: 6, name: '竞争对手'},
    //                 {source: '乔纳森-艾夫', target: '乔布斯', weight: 1, name: '爱将'},
    //                 {source: '蒂姆-库克', target: '乔布斯', weight: 1},
    //                 {source: '龙-韦恩', target: '乔布斯', weight: 1},
    //                 {source: '克拉拉-乔布斯', target: '保罗-乔布斯', weight: 1},
    //                 {source: '奥巴马', target: '保罗-乔布斯', weight: 1},
    //                 {source: '奥巴马', target: '克拉拉-乔布斯', weight: 1},
    //                 {source: '奥巴马', target: '劳伦-鲍威尔', weight: 1},
    //                 {source: '奥巴马', target: '史蒂夫-沃兹尼艾克', weight: 1},
    //                 {source: '比尔-盖茨', target: '奥巴马', weight: 6},
    //                 {source: '比尔-盖茨', target: '克拉拉-乔布斯', weight: 1},
    //                 {source: '蒂姆-库克', target: '奥巴马', weight: 1}
    //             ]
    //         }
    //     ]
    // };
    // forceChart.setOption(forceoption);
    // $(window).resize(forceChart.resize);
    //
    // var gaugeChart = echarts.init(document.getElementById("echarts-gauge-chart"));
    // var gaugeoption = {
    //     tooltip: {
    //         formatter: "{a} <br/>{c} {b}"
    //     },
    //     toolbox: {
    //         show: true,
    //         feature: {
    //             mark: {show: true},
    //             restore: {show: true},
    //             saveAsImage: {show: true}
    //         }
    //     },
    //     series: [
    //         {
    //             name: '速度',
    //             type: 'gauge',
    //             min: 0,
    //             max: 220,
    //             splitNumber: 11,
    //             axisLine: {            // 坐标轴线
    //                 lineStyle: {       // 属性lineStyle控制线条样式
    //                     width: 10
    //                 }
    //             },
    //             axisTick: {            // 坐标轴小标记
    //                 length: 15,        // 属性length控制线长
    //                 lineStyle: {       // 属性lineStyle控制线条样式
    //                     color: 'auto'
    //                 }
    //             },
    //             splitLine: {           // 分隔线
    //                 length: 20,         // 属性length控制线长
    //                 lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
    //                     color: 'auto'
    //                 }
    //             },
    //             title: {
    //                 textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
    //                     fontWeight: 'bolder',
    //                     fontSize: 20,
    //                     fontStyle: 'italic'
    //                 }
    //             },
    //             detail: {
    //                 textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
    //                     fontWeight: 'bolder'
    //                 }
    //             },
    //             data: [{value: 40, name: 'km/h'}]
    //         },
    //         {
    //             name: '转速',
    //             type: 'gauge',
    //             center: ['25%', '55%'],    // 默认全局居中
    //             radius: '50%',
    //             min: 0,
    //             max: 7,
    //             endAngle: 45,
    //             splitNumber: 7,
    //             axisLine: {            // 坐标轴线
    //                 lineStyle: {       // 属性lineStyle控制线条样式
    //                     width: 8
    //                 }
    //             },
    //             axisTick: {            // 坐标轴小标记
    //                 length: 12,        // 属性length控制线长
    //                 lineStyle: {       // 属性lineStyle控制线条样式
    //                     color: 'auto'
    //                 }
    //             },
    //             splitLine: {           // 分隔线
    //                 length: 20,         // 属性length控制线长
    //                 lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
    //                     color: 'auto'
    //                 }
    //             },
    //             pointer: {
    //                 width: 5
    //             },
    //             title: {
    //                 offsetCenter: [0, '-30%'],       // x, y，单位px
    //             },
    //             detail: {
    //                 textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
    //                     fontWeight: 'bolder'
    //                 }
    //             },
    //             data: [{value: 1.5, name: 'x1000 r/min'}]
    //         },
    //         {
    //             name: '油表',
    //             type: 'gauge',
    //             center: ['75%', '50%'],    // 默认全局居中
    //             radius: '50%',
    //             min: 0,
    //             max: 2,
    //             startAngle: 135,
    //             endAngle: 45,
    //             splitNumber: 2,
    //             axisLine: {            // 坐标轴线
    //                 lineStyle: {       // 属性lineStyle控制线条样式
    //                     color: [[0.2, '#ff4500'], [0.8, '#48b'], [1, '#228b22']],
    //                     width: 8
    //                 }
    //             },
    //             axisTick: {            // 坐标轴小标记
    //                 splitNumber: 5,
    //                 length: 10,        // 属性length控制线长
    //                 lineStyle: {       // 属性lineStyle控制线条样式
    //                     color: 'auto'
    //                 }
    //             },
    //             axisLabel: {
    //                 formatter: function (v) {
    //                     switch (v + '') {
    //                         case '0' :
    //                             return 'E';
    //                         case '1' :
    //                             return 'Gas';
    //                         case '2' :
    //                             return 'F';
    //                     }
    //                 }
    //             },
    //             splitLine: {           // 分隔线
    //                 length: 15,         // 属性length控制线长
    //                 lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
    //                     color: 'auto'
    //                 }
    //             },
    //             pointer: {
    //                 width: 2
    //             },
    //             title: {
    //                 show: false
    //             },
    //             detail: {
    //                 show: false
    //             },
    //             data: [{value: 0.5, name: 'gas'}]
    //         },
    //         {
    //             name: '水表',
    //             type: 'gauge',
    //             center: ['75%', '50%'],    // 默认全局居中
    //             radius: '50%',
    //             min: 0,
    //             max: 2,
    //             startAngle: 315,
    //             endAngle: 225,
    //             splitNumber: 2,
    //             axisLine: {            // 坐标轴线
    //                 lineStyle: {       // 属性lineStyle控制线条样式
    //                     color: [[0.2, '#ff4500'], [0.8, '#48b'], [1, '#228b22']],
    //                     width: 8
    //                 }
    //             },
    //             axisTick: {            // 坐标轴小标记
    //                 show: false
    //             },
    //             axisLabel: {
    //                 formatter: function (v) {
    //                     switch (v + '') {
    //                         case '0' :
    //                             return 'H';
    //                         case '1' :
    //                             return 'Water';
    //                         case '2' :
    //                             return 'C';
    //                     }
    //                 }
    //             },
    //             splitLine: {           // 分隔线
    //                 length: 15,         // 属性length控制线长
    //                 lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
    //                     color: 'auto'
    //                 }
    //             },
    //             pointer: {
    //                 width: 2
    //             },
    //             title: {
    //                 show: false
    //             },
    //             detail: {
    //                 show: false
    //             },
    //             data: [{value: 0.5, name: 'gas'}]
    //         }
    //     ]
    // };
    // gaugeChart.setOption(gaugeoption);
    // $(window).resize(gaugeChart.resize);
    //
    // var funnelChart = echarts.init(document.getElementById("echarts-funnel-chart"));
    // var funneloption = {
    //     title: {
    //         text: '漏斗图',
    //         subtext: '纯属虚构'
    //     },
    //     tooltip: {
    //         trigger: 'item',
    //         formatter: "{a} <br/>{b} : {c}%"
    //     },
    //     legend: {
    //         data: ['展现', '点击', '访问', '咨询', '订单']
    //     },
    //     calculable: true,
    //     series: [
    //         {
    //             name: '漏斗图',
    //             type: 'funnel',
    //             width: '40%',
    //             data: [
    //                 {value: 60, name: '访问'},
    //                 {value: 40, name: '咨询'},
    //                 {value: 20, name: '订单'},
    //                 {value: 80, name: '点击'},
    //                 {value: 100, name: '展现'}
    //             ]
    //         },
    //         {
    //             name: '金字塔',
    //             type: 'funnel',
    //             x: '50%',
    //             sort: 'ascending',
    //             itemStyle: {
    //                 normal: {
    //                     // color: 各异,
    //                     label: {
    //                         position: 'left'
    //                     }
    //                 }
    //             },
    //             data: [
    //                 {value: 60, name: '访问'},
    //                 {value: 40, name: '咨询'},
    //                 {value: 20, name: '订单'},
    //                 {value: 80, name: '点击'},
    //                 {value: 100, name: '展现'}
    //             ]
    //         }
    //     ]
    // };
    //
    // funnelChart.setOption(funneloption);
    // $(window).resize(funnelChart.resize);

});
