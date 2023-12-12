import React, { useEffect, useState } from 'react'
import "./TodoList.css"
import list_icon from "../assets/list_icon.png"
import tick_icon from "../assets/tick_icon.png"
import wrong_icon from "../assets/wrong_icon.png"
import axios from 'axios'
import Todo from '../Todo/Todo'
const TodoList = () => {
  const [todos,setTodos] = useState([])
  const [completed,setCompleted] = useState(0)
  const [data,setData] = useState({
    todoName : "",
    status : "pending",
  })
  const handleChange = (e) =>{
    setData({...data,[e.target.name]:e.target.value})
    console.log(data);
  }
  const handleSubmit= (e) =>{
    e.preventDefault()
    axios.post("http://localhost:9090/todo/add",{
      todoName : data.todoName,
      status : "pending"
    }).then((res) => console.log(res));
  }
  useEffect(() => {

    axios.get("http://localhost:9090/todo/all")
    .then(res => setTodos(res.data))

    axios.get("http://localhost:9090/todo/completedcount")
    .then((res) => setCompleted(res.data))
  }, [todos,completed])
  
  return (
    <div className='card'> 
        <div className="list-header">
            <img src={list_icon} alt="" />
            <p>Todo List</p>
        </div>
        <div className="add-task">
            <input placeholder='Add your todo' type='text' name='todoName' value={data.todoName} onChange={handleChange}/>
            <button onClick={handleSubmit}>Add</button>
        </div>
        <div className="task-type">
              <img src={tick_icon} alt="" />
              <p>Complete all tasks</p>
              <img style={{marginLeft:"50px"}} src={wrong_icon} alt="" />
              <p>Delete comp tasks</p>
        </div>
        <div className="tasks">
            {todos.length !== 0 &&  todos.map((todo,index) => {
              return <Todo key={index} id={todo.id} todo_name={todo.todoName} status={todo.status} />
            })}
        </div>
        <div className="task-info">
        <button>Filter</button>
          <p>Completed : {completed}</p>
          <p>Total Tasks : {todos.length}</p>
        </div>
    </div>
  )
}

export default TodoList