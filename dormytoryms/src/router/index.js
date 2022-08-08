import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "@/views/Login"
import SystemAdmin from "@/views/SystemAdmin";
import DormitoryAdminManager from "@/views/DormitoryAdminManager";
import DormitoryAdminAdd from "@/views/DormitoryAdminAdd";
import DormitoryAdminUpdate from "@/views/DormitoryAdminUpdate";
import StudentAdd from "@/views/StudentAdd";
import StudentManager from "@/views/StudentManager";
import StudentUpdate from "@/views/StudentUpdate";
import BuildingAdd from "@/views/BuildingAdd";
import BuildingManager from "@/views/BuildingManager";
import BuildingUpdate from "@/views/BuildingUpdate";
import DormitoryAdd from "@/views/DormitoryAdd";
import DormitoryManager from "@/views/DormitoryManager";
import DormitoryUpdate from "@/views/DormitoryUpdate";
import MoveoutRegister from "@/views/MoveoutRegister";

Vue.use(VueRouter)

const routes = [
  {
    path: '/dormitoryAdmin',
    name: '宿舍管理员',
    component: DormitoryAdmin,
    redirect: '/absentRegister',
    children:[
      {
        path: '/absentRecord2',
        name: '缺寝记录',
        component: AbsentRecord
      },
      {
        path: '/absentRegister',
        name: '缺寝登记',
        component: AbsentRegister
      }
    ]
  },
  {
    path: '/systemAdmin',
    name: '系统管理员',
    component: SystemAdmin,
    redirect: '/dormitoryAdminAdd',
    children:[
      {
        path: '/dormitoryAdminManager',
        name: '宿舍管理',
        component: DormitoryAdminManager
      },
      {
        path: '/dormitoryAdminAdd',
        name: '添加宿管',
        component: DormitoryAdminAdd
      },
      {
        path: '/dormitoryAdminUpdate',
        name: '修改宿舍',
        component: DormitoryAdminUpdate
      },
      {
        path: '/studentAdd',
        name: '添加学生',
        component: StudentAdd
      },
      {
        path: '/studentManager',
        name: '学生管理',
        component: StudentManager
      },
      {
        path: '/studentUpdate',
        name: '修改学生',
        component: StudentUpdate
      },
      {
        path: '/buildingAdd',
        name: '添加楼宇',
        component: BuildingAdd
      },
      {
        path: '/buildingManager',
        name: '楼宇管理',
        component: BuildingManager
      },
      {
        path: '/buildingUpdate',
        name: '楼宇编辑',
        component: BuildingUpdate
      },
      {
        path: '/dormitoryAdd',
        name: '添加宿舍',
        component:DormitoryAdd
      },
      {
        path: '/dormitoryManager',
        name: '宿舍管理',
        component:DormitoryManager
      },
      {
        path: '/dormitoryUpdate',
        name: '宿舍编辑',
        component:DormitoryUpdate
      },
      {
        path: '/moveoutRegister',
        name: '迁出登记',
        component:MoveoutRegister
      }
    ]
  },
  {
    path: '/login',
    name: '登录',
    component: Login
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
