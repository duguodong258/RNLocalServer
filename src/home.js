/**
 * @author Jelly
 *
 * @time   2020/3/16
 *
 * @des demo示范了插andServer的启动 停止服务 以及加载原生本地的网页
 */
import React, { Component } from 'react';
import { View, Text, NativeModules, Dimensions,TouchableNativeFeedback } from 'react-native'
import WebView from 'react-native-webview'

var { width, height } = Dimensions.get("window");//第一种写法

export default class Home extends Component {

    state = {
        url:null,
    };

    render(){

        return(
            <View style={{justifyContent: 'center',alignItems:'center',backgroundColor:'#567',flex:1}}>

                <View style={{flexDirection:'row',marginTop:10, marginBottom:10,}}>
                    <TouchableNativeFeedback onPress={()=> NativeModules.RNAndServer.startLocalServer()}>
                        <Text style={{
                                padding:5,
                                fontWeight:'bold',
                                backgroundColor:'#d4ff66',
                                borderRadius:5,
                                textAlign:'center'
                            }}>启动服务</Text>
                    </TouchableNativeFeedback>

                    <Text
                        onPress={()=> NativeModules.RNAndServer.stopLocalServer()}
                        style={{
                            padding:5,
                            fontWeight:'bold',
                            backgroundColor:'#73beff',
                            borderRadius:5,
                            marginLeft:10,
                            textAlign:'center'
                        }}>停止服务</Text>
                </View>

                <TouchableNativeFeedback onPress={()=> {
                    NativeModules.RNAndServerDemo.getHtmlUrl((msg) => {this.setState({url:msg})})
                }}>
                    <Text style={{
                            fontSize:15,
                            width:150,
                            height:40,
                            marginBottom:10,
                            textAlignVertical:'center',
                            fontWeight:'bold',
                            backgroundColor:'#e18907',
                            borderRadius:5,
                            textAlign:'center'
                        }}>加载手机本地网页</Text>
                </TouchableNativeFeedback>

                <WebView
                    androidjavaScriptEnabled={true}
                    style={{backgroundColor:'#fff',width,height}}
                    startInLoadingState={true}
                    source={{uri:this.state.url}}/>

                <Text style={{position:'absolute',color:'#CCC',fontSize:30}}>{this.state.url?'':'Webview'}</Text>
            </View>
        )
    }
}