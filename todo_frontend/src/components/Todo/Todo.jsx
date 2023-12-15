import React from 'react'
import "./Todo.css"
import edit_icom from "../assets/edit_icon.png"
import delete_icon from "../assets/delete_icon.png"
import axios from 'axios'
import { ToastContainer, toast } from 'react-toastify'

const Todo = (props) => {
  return (
    <div className='todo'>
      <input type='checkbox'/>
      <p>{props.todo_name}</p>
      <img src={edit_icom} alt='' />
      <img src={delete_icon} alt='' onClick={() => {
        axios.delete(`http://localhost:9090/todo/delete/${props.id}`)
        .then((res) => toast.warning(res.data))
      }}/>
      <ToastContainer/>
    </div>
  )
}

export default Todo